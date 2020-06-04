package com.blackdragon2447.cyberdogs.entities;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;

import com.blackdragon2447.cyberdogs.init.ModEntitieTypes;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BegGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.items.IItemHandler;

@SuppressWarnings("unused")
public class CyberDog extends TameableEntity{
	


	public static int timer = 0;
	public static boolean pos;

	@CapabilityInject(IItemHandler.class)
	static Capability<IItemHandler> ITEM_HANDLER_CAPABILITY = null;
	private SitGoal sitGoal;
	private SleepGoal sleepGoal;
	private static final DataParameter<Byte> DOG_FLAGS = EntityDataManager.createKey(CyberDog.class, DataSerializers.BYTE);
	private static final DataParameter<Optional<UUID>> TRUSTED_UUID_SECONDARY = EntityDataManager.createKey(CyberDog.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	private static final DataParameter<Optional<UUID>> TRUSTED_UUID_MAIN = EntityDataManager.createKey(CyberDog.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Map<Integer, EntityDataManager.DataEntry<?>> entries = Maps.newHashMap();
	
	public CyberDog(EntityType<CyberDog> entityType, World worldIn) {
		super(entityType, worldIn);
		//this.dataManager.set(DOG_FLAGS, (byte)(this.dataManager.get(DOG_FLAGS) | 1));

	}

	@Override
	public CyberDog createChild(AgeableEntity ageable) {
		CyberDog entity = new CyberDog(ModEntitieTypes.CYBERDOG.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return entity;
	}
	
	@Override
	protected void registerGoals() {
		
		this.sitGoal = new SitGoal(this);
		this.sleepGoal = new SleepGoal();
	    this.goalSelector.addGoal(1, new SwimGoal(this));
	    this.goalSelector.addGoal(2, this.sitGoal);
	    this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
	    this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
	    this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
	    this.goalSelector.addGoal(6, new BreedGoal(this, 1.0D));
	    this.goalSelector.addGoal(7, this.sleepGoal);
	    this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
	    //this.goalSelector.addGoal(8, new BegGoal(this, 8.0F));
	    //this.goalSelector.addGoal(8, new FindItemsGoal());
	    this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	    this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
	    this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
	    this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	    this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
	    this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
		
	}
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override
	public void livingTick() {
		super.livingTick();
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.5F);
		//this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.5D);
		
	}

	
	

	protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
		return ProjectileHelper.fireArrow(this, arrowStack, distanceFactor);
	}
	
	
	
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		System.out.println();
		System.out.println(DOG_FLAGS.toString());
		System.out.println();
	      ItemStack itemstack = player.getHeldItem(hand);
	      Item item = itemstack.getItem();
	      if (itemstack.getItem() instanceof SpawnEggItem) {
	         return super.processInteract(player, hand);
	      } else if (this.world.isRemote) {
	         return this.isOwner(player) || item == Items.BONE && !this.isAngry();
	      } else {
	         if (this.isTamed()) {
	            if (item.isFood() && item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
	               if (!player.abilities.isCreativeMode) {
	                  itemstack.shrink(1);
	               }

	               this.heal((float)item.getFood().getHealing());
	               return true;
	            }

	            if (itemstack.isEmpty()) {
	               boolean flag = super.processInteract(player, hand);
	               if ((!flag || this.isChild())) {
	                  if((!this.isSitting()) && (!this.isSleeping()))
	            	   this.sitGoal.setSitting(true);
	                  
	                  else if((this.isSitting()) && (!this.isSleeping())) {
	                	  this.setSitting(false);
	                	  CyberDog.this.setSleeping(true);
	                  }
	                  else {
	                	  CyberDog.this.setSleeping(false);
	                	  
	                  }
	                  
	               }

	               return flag;
	            }

	            

	               return true;
	            }

	            if (this.isOwner(player) && !this.isBreedingItem(itemstack)) {
	               this.sitGoal.setSitting(!this.isSitting());
	               this.isJumping = false;
	               this.navigator.clearPath();
	               this.setAttackTarget((LivingEntity)null);
	            }
	         }if (item == Items.BONE && !this.isAngry()) {
	            if (!player.abilities.isCreativeMode) {
	               itemstack.shrink(1);
	            }

	            if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
	               this.setTamedBy(player);
	               this.navigator.clearPath();
	               this.setAttackTarget((LivingEntity)null);
	               this.sitGoal.setSitting(true);
	               this.setSleeping(false);
	               this.world.setEntityState(this, (byte)7);
	            } else {
	               this.world.setEntityState(this, (byte)6);
	            }

	            return true;
	         }

	         return super.processInteract(player, hand);
	      
	   } 
	
	
	public boolean isAngry() {
	      return (this.dataManager.get(TAMED) & 2) != 0;
	   }

	
	
	//sleepgoal//
	   public class SleepGoal extends BaseGoal {
		      //private Object rand;
		      private int field_220825_c = CyberDog.this.rand.nextInt(140);

		      public SleepGoal() {
		         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		      }

		      /**
		       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		       * method as well.
		       */
		      public boolean shouldExecute() {
		         if (CyberDog.this.moveStrafing == 0.0F && CyberDog.this.moveVertical == 0.0F && CyberDog.this.moveForward == 0.0F) {
		            return this.func_220823_j() || CyberDog.this.isSleeping();
		         } else {
		            return false;
		         }
		      }

		      /**
		       * Returns whether an in-progress EntityAIBase should continue executing
		       */
		      public boolean shouldContinueExecuting() {
		         return this.func_220823_j();
		      }

		      private boolean func_220823_j() {
		         if (this.field_220825_c > 0) {
		            --this.field_220825_c;
		            return false;
		         } else {
		            return world.isDaytime() && this.func_220813_g() && !this.func_220814_h();
		         }
		      }

		      /**
		       * Reset the task's internal state. Called when this task is interrupted by another one
		       */
		      public void resetTask() {
		         this.field_220825_c = CyberDog.this.rand.nextInt(140);
		         CyberDog.this.func_213499_en();
		      }

		      /**
		       * Execute a one shot task or start executing a continuous task
		       */
		      public void startExecuting() {
		         //CyberDog.this.setSitting(false);
		         CyberDog.this.setCrouching(false);
		         CyberDog.this.func_213502_u(false);
		         CyberDog.this.setJumping(false);
		         CyberDog.this.setSleeping(true);
		         CyberDog.this.getNavigator().clearPath();
		         CyberDog.this.getMoveHelper().setMoveTo(CyberDog.this.getPosX(), CyberDog.this.getPosY(), CyberDog.this.getPosZ(), 0.0D);
		      }
		   }
	   
	   //basegoal//
	   abstract class BaseGoal extends Goal {
		   
		      private final EntityPredicate field_220816_b = (new EntityPredicate()).setDistance(12.0D).setLineOfSiteRequired().setCustomPredicate(CyberDog.this.new AlertablePredicate());

		      private BaseGoal() {
		      }

		      protected boolean func_220813_g() {
		         BlockPos blockpos = new BlockPos(CyberDog.this);
		         return !CyberDog.this.world.canSeeSky(blockpos) && CyberDog.this.getBlockPathWeight(blockpos) >= 0.0F;
		      }

		      protected boolean func_220814_h() {
		         return !CyberDog.this.world.getTargettableEntitiesWithinAABB(LivingEntity.class, this.field_220816_b, CyberDog.this, CyberDog.this.getBoundingBox().grow(12.0D, 6.0D, 12.0D)).isEmpty();
		      }
		   }
	   
	   
	   public void func_213502_u(boolean p_213502_1_) {
		      this.setCyberDogFlag(8, p_213502_1_);
		   }
	   public void setCrouching(boolean p_213451_1_) {
		      this.setCyberDogFlag(4, p_213451_1_);
		   }
	   
	   private void setCyberDogFlag(int p_213505_1_, boolean p_213505_2_) {
		      if (p_213505_2_) {
		         this.dataManager.set(DOG_FLAGS, (byte)(this.dataManager.get(DOG_FLAGS) | p_213505_1_));
		      } else {
		         this.dataManager.set(DOG_FLAGS, (byte)(this.dataManager.get(DOG_FLAGS) & ~p_213505_1_));
		      }

		   }
	   
	   private void func_213499_en() {
		      this.func_213502_u(false);
		      this.setCrouching(false);
		      //this.setSitting(false);
		      this.setSleeping(false);
		   }
	   
	   public class AlertablePredicate implements Predicate<LivingEntity> {
		      public boolean test(LivingEntity p_test_1_) {
		         if (p_test_1_ instanceof CyberDog) {
		            return false;
		         } else if (!(p_test_1_ instanceof ChickenEntity) && !(p_test_1_ instanceof RabbitEntity) && !(p_test_1_ instanceof MonsterEntity)) {
		            if (p_test_1_ instanceof TameableEntity) {
		               return !((TameableEntity)p_test_1_).isTamed();
		            } else if (!(p_test_1_ instanceof PlayerEntity) || !p_test_1_.isSpectator() && !((PlayerEntity)p_test_1_).isCreative()) {
		               if (CyberDog.this.isTrustedUUID(p_test_1_.getUniqueID())) {
		                  return false;
		               } else {
		                  return !p_test_1_.isSleeping() && !p_test_1_.isDiscrete();
		               }
		            } else {
		               return false;
		            }
		         } else {
		            return true;
		         }
		      }
		   }
	   
	   private boolean isTrustedUUID(UUID p_213468_1_) {
		      return this.getTrustedUUIDs().contains(p_213468_1_);
		   }
	   
	   private List<UUID> getTrustedUUIDs() {
		      List<UUID> list = Lists.newArrayList();
		      list.add(this.dataManager.get(TRUSTED_UUID_SECONDARY).orElse((UUID)null));
		      list.add(this.dataManager.get(TRUSTED_UUID_MAIN).orElse((UUID)null));
		      return list;
		   }
	   
	   private void setSleeping(boolean p_213485_1_) {
		      this.setDogFlag(32, p_213485_1_);
		   }
	   
	   private void setDogFlag(int p_213505_1_, boolean p_213505_2_) {
		   
		   if(DOG_FLAGS != null){
		   		if (p_213505_2_) {
		   			this.dataManager.set(DOG_FLAGS, (byte)(this.dataManager.get(DOG_FLAGS) | p_213505_1_));
		   		} else {
		   			this.dataManager.set(DOG_FLAGS, (byte)(this.dataManager.get(DOG_FLAGS) & ~p_213505_1_));
		   		}
		   }

	   }
	   
	   public <T> T get(DataParameter<T> key) {
		      return this.getEntry(key).getValue();
		   }
	   
	   
	   private <T> EntityDataManager.DataEntry<T> getEntry(DataParameter<T> key) {
		      this.lock.readLock().lock();

		      EntityDataManager.DataEntry<T> dataentry;
		      try {
		         dataentry = (EntityDataManager.DataEntry<T>) this.entries.get(key.getId());
		      } catch (Throwable throwable) {
		         CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Getting synched entity data");
		         CrashReportCategory crashreportcategory = crashreport.makeCategory("Synched entity data");
		         crashreportcategory.addDetail("Data ID", key);
		         throw new ReportedException(crashreport);
		      } finally {
		         this.lock.readLock().unlock();
		      }

		      return dataentry;
		   }
	   
	

}
