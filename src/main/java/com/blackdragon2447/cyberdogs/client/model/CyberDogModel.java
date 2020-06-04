package com.blackdragon2447.cyberdogs.client.model;

import com.blackdragon2447.cyberdogs.entities.CyberDog;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CyberDogModel<T extends CyberDog> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer mane;
	private final ModelRenderer Mainbody;
	private final ModelRenderer gearsL;
	private final ModelRenderer gear1;
	private final ModelRenderer Layer5;
	private final ModelRenderer layer6;
	private final ModelRenderer gear2;
	private final ModelRenderer Layer7;
	private final ModelRenderer layer8;
	private final ModelRenderer gearsR;
	private final ModelRenderer gear4;
	private final ModelRenderer Layer4;
	private final ModelRenderer layer9;
	private final ModelRenderer gear3;
	private final ModelRenderer Layer2;
	private final ModelRenderer layer3;
	private final ModelRenderer head;
	private final ModelRenderer jawgear;
	private final ModelRenderer jawgear2;
	private final ModelRenderer jaw3;
	private final ModelRenderer jaw2;
	private final ModelRenderer jaw;
	private final ModelRenderer tail;
	private final ModelRenderer legs;
	private final ModelRenderer back;
	private final ModelRenderer left;
	private final ModelRenderer right;
	private final ModelRenderer front;
	private final ModelRenderer left2;
	private final ModelRenderer kneeplate;
	private final ModelRenderer right2;
	private final ModelRenderer kneeplate2;
	private final ModelRenderer sholderplate;
	//private boolean pos = false;

	public CyberDogModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		mane = new ModelRenderer(this);
		mane.setRotationPoint(1.0F, -14.0F, 2.0F);
		body.addChild(mane);
		mane.setTextureOffset(0, 15).addBox(-5.0F, -1.0F, -8.0F, 8.0F, 7.0F, 6.0F, 0.0F, false);

		Mainbody = new ModelRenderer(this);
		Mainbody.setRotationPoint(3.0F, -8.0F, 0.0F);
		body.addChild(Mainbody);
		Mainbody.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 9.0F, 0.0F, false);
		Mainbody.setTextureOffset(22, 15).addBox(-4.0F, -6.3F, 0.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 0).addBox(-3.5F, -7.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 0).addBox(-3.5F, -7.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mainbody.setTextureOffset(4, 0).addBox(-3.5F, -7.0F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		gearsL = new ModelRenderer(this);
		gearsL.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mainbody.addChild(gearsL);
		

		gear1 = new ModelRenderer(this);
		gear1.setRotationPoint(0.4F, -1.8F, 1.6F);
		gearsL.addChild(gear1);
		

		Layer5 = new ModelRenderer(this);
		Layer5.setRotationPoint(0.0F, 0.0F, 0.0F);
		gear1.addChild(Layer5);
		Layer5.setTextureOffset(0, 45).addBox(-0.6F, -2.8F, 0.6F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		layer6 = new ModelRenderer(this);
		layer6.setRotationPoint(0.4F, -1.8F, 1.6F);
		gear1.addChild(layer6);
		setRotationAngle(layer6, -0.7854F, 0.0F, 0.0F);
		layer6.setTextureOffset(0, 45).addBox(-1.1F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		gear2 = new ModelRenderer(this);
		gear2.setRotationPoint(0.3F, -2.4F, 4.0F);
		gearsL.addChild(gear2);
		

		Layer7 = new ModelRenderer(this);
		Layer7.setRotationPoint(0.0F, 0.0F, 0.0F);
		gear2.addChild(Layer7);
		Layer7.setTextureOffset(0, 45).addBox(-0.6F, -2.8F, 0.6F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		layer8 = new ModelRenderer(this);
		layer8.setRotationPoint(0.4F, -1.8F, 1.6F);
		gear2.addChild(layer8);
		setRotationAngle(layer8, -0.7854F, 0.0F, 0.0F);
		layer8.setTextureOffset(0, 45).addBox(-1.1F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		gearsR = new ModelRenderer(this);
		gearsR.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mainbody.addChild(gearsR);
		

		gear4 = new ModelRenderer(this);
		gear4.setRotationPoint(-6.4F, -2.4F, 4.0F);
		gearsR.addChild(gear4);
		

		Layer4 = new ModelRenderer(this);
		Layer4.setRotationPoint(0.0F, 0.0F, 0.0F);
		gear4.addChild(Layer4);
		Layer4.setTextureOffset(0, 45).addBox(-0.4F, -2.8F, 0.6F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		layer9 = new ModelRenderer(this);
		layer9.setRotationPoint(-0.4F, -1.8F, 1.6F);
		gear4.addChild(layer9);
		setRotationAngle(layer9, -0.7854F, 0.0F, 0.0F);
		layer9.setTextureOffset(0, 45).addBox(0.1F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		gear3 = new ModelRenderer(this);
		gear3.setRotationPoint(-6.4F, -1.8F, 1.6F);
		gearsR.addChild(gear3);
		

		Layer2 = new ModelRenderer(this);
		Layer2.setRotationPoint(0.0F, 0.0F, 0.0F);
		gear3.addChild(Layer2);
		Layer2.setTextureOffset(0, 45).addBox(-0.4F, -2.8F, 0.6F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		layer3 = new ModelRenderer(this);
		layer3.setRotationPoint(-0.4F, -1.8F, 1.6F);
		gear3.addChild(layer3);
		setRotationAngle(layer3, -0.7854F, 0.0F, 0.0F);
		layer3.setTextureOffset(0, 45).addBox(0.1F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -14.0F, -6.0F);
		body.addChild(head);
		head.setTextureOffset(5, 34).addBox(1.0F, -4.5F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 18).addBox(-3.0F, -4.5F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 28).addBox(-1.5F, 0.5F, -6.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(21, 0).addBox(-3.0F, -2.5F, -3.0F, 6.0F, 6.0F, 3.0F, 0.0F, false);

		jawgear = new ModelRenderer(this);
		jawgear.setRotationPoint(-2.05F, 3.0F, -3.2F);
		head.addChild(jawgear);
		setRotationAngle(jawgear, 0.0F, -0.1745F, 0.0F);
		jawgear.setTextureOffset(12, 41).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		jawgear2 = new ModelRenderer(this);
		jawgear2.setRotationPoint(2.05F, 3.0F, -3.2F);
		head.addChild(jawgear2);
		setRotationAngle(jawgear2, 0.0F, 0.1745F, 0.0F);
		jawgear2.setTextureOffset(12, 41).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

		jaw3 = new ModelRenderer(this);
		jaw3.setRotationPoint(4.4F, 2.5F, -0.3F);
		head.addChild(jaw3);
		setRotationAngle(jaw3, 0.1745F, 0.0F, 0.0F);
		jaw3.setTextureOffset(24, 24).addBox(-5.9F, -3.0F, -5.2F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		jaw2 = new ModelRenderer(this);
		jaw2.setRotationPoint(4.4F, 3.5F, -0.8F);
		head.addChild(jaw2);
		setRotationAngle(jaw2, 0.0F, -0.3491F, 0.0F);
		jaw2.setTextureOffset(31, 9).addBox(-7.3239F, -3.0F, -2.907F, 1.0F, 3.0F, 4.0F, 0.0F, true);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(2.0F, 3.5F, -6.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.0F, 0.3491F, 0.0F);
		jaw.setTextureOffset(31, 9).addBox(-1.4349F, -3.0F, -0.1708F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -13.0F, 8.0F);
		body.addChild(tail);
		setRotationAngle(tail, -0.5236F, 0.0F, 0.0F);
		tail.setTextureOffset(9, 28).addBox(-0.5F, -0.651F, 2.3954F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		tail.setTextureOffset(36, 36).addBox(-1.0F, -1.134F, 0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		tail.setTextureOffset(34, 24).addBox(-1.0F, -1.1081F, 3.0553F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		tail.setTextureOffset(22, 17).addBox(-0.5F, -0.63F, 4.6592F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		tail.setTextureOffset(0, 15).addBox(-1.0F, -1.1506F, 5.6288F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		tail.setTextureOffset(22, 15).addBox(-0.5F, -0.6372F, 6.2716F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(3.0F, 0.0F, -4.0F);
		body.addChild(legs);
		

		back = new ModelRenderer(this);
		back.setRotationPoint(-3.0F, -8.0F, 11.0F);
		legs.addChild(back);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(1.5F, 0.0F, 0.0F);
		back.addChild(left);
		left.setTextureOffset(28, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		right = new ModelRenderer(this);
		right.setRotationPoint(-1.5F, 0.0F, 0.0F);
		back.addChild(right);
		right.setTextureOffset(28, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		front = new ModelRenderer(this);
		front.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(front);
		

		left2 = new ModelRenderer(this);
		left2.setRotationPoint(-0.5F, -8.0F, 0.0F);
		front.addChild(left2);
		left2.setTextureOffset(33, 18).addBox(1.0F, -2.0F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		left2.setTextureOffset(12, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		left2.setTextureOffset(8, 40).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		left2.setTextureOffset(12, 32).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		kneeplate = new ModelRenderer(this);
		kneeplate.setRotationPoint(0.5F, 8.0F, 0.0F);
		left2.addChild(kneeplate);
		kneeplate.setTextureOffset(6, 41).addBox(-1.5F, -6.0F, -1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		kneeplate.setTextureOffset(4, 40).addBox(0.5F, -6.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		kneeplate.setTextureOffset(4, 40).addBox(-1.5F, -6.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		right2 = new ModelRenderer(this);
		right2.setRotationPoint(-5.5F, -8.0F, 0.0F);
		front.addChild(right2);
		right2.setTextureOffset(8, 40).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		right2.setTextureOffset(33, 18).addBox(-2.0F, -2.0F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		right2.setTextureOffset(20, 29).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		right2.setTextureOffset(20, 33).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		kneeplate2 = new ModelRenderer(this);
		kneeplate2.setRotationPoint(0.5F, 8.0F, 0.0F);
		right2.addChild(kneeplate2);
		kneeplate2.setTextureOffset(0, 43).addBox(-1.5F, -6.0F, -1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		kneeplate2.setTextureOffset(0, 40).addBox(0.5F, -6.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		kneeplate2.setTextureOffset(0, 40).addBox(-1.5F, -6.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		sholderplate = new ModelRenderer(this);
		sholderplate.setRotationPoint(-3.0F, -10.8F, 0.4F);
		front.addChild(sholderplate);
		setRotationAngle(sholderplate, -0.3491F, 0.0F, 0.0F);
		sholderplate.setTextureOffset(0, 0).addBox(3.3F, -8.4435F, -0.7188F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		sholderplate.setTextureOffset(0, 0).addBox(-4.3F, -8.4435F, -0.7188F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		sholderplate.setTextureOffset(0, 34).addBox(-5.0F, -1.9485F, -1.4407F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		sholderplate.setTextureOffset(0, 34).addBox(4.0F, -1.9485F, -1.4407F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		
		
		}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	      
	   }

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		
	}
	

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		if (entityIn.isSitting()) {
			body.setRotationPoint(0.0F, 24.0F, -7.0F);
			setRotationAngle(body, -0.7854F, 0.0F, 0.0F);
			mane.setRotationPoint(1.0F, -14.0F, 2.0F);
			setRotationAngle(mane, 0.1745F, 0.0F, 0.0F);
			Mainbody.setRotationPoint(3.0F, -8.0F, 0.0F);
			gearsL.setRotationPoint(0.0F, 0.0F, 0.0F);
			gear1.setRotationPoint(0.0F, 0.0F, 0.0F);
			Layer5.setRotationPoint(0.0F, 0.0F, 0.0F);
			layer6.setRotationPoint(0.4F, -1.8F, 1.6F);
			setRotationAngle(layer6, -0.7854F, 0.0F, 0.0F);
			gear2.setRotationPoint(0.3F, -2.4F, 4.0F);
			Layer7.setRotationPoint(-0.3F, 1.8F, -1.6F);
			layer8.setRotationPoint(0.1F, 0.0F, 0.0F);
			setRotationAngle(layer8, -0.7854F, 0.0F, 0.0F);
			gearsR.setRotationPoint(0.0F, 0.0F, 0.0F);
			gear4.setRotationPoint(-6.0F, -0.6F, 2.4F);
			Layer4.setRotationPoint(0.0F, 0.0F, 0.0F);
			layer9.setRotationPoint(-0.4F, -1.8F, 1.6F);
			setRotationAngle(layer9, -0.7854F, 0.0F, 0.0F);
			gear3.setRotationPoint(-6.0F, 0.0F, 0.0F);
			Layer2.setRotationPoint(0.0F, 0.0F, 0.0F);
			layer3.setRotationPoint(-0.4F, -1.8F, 1.6F);
			setRotationAngle(layer3, -0.7854F, 0.0F, 0.0F);
			head.setRotationPoint(0.0F, -14.0F, -6.0F);
			setRotationAngle(head, 0.5236F, 0.0F, 0.0F);
			jawgear.setRotationPoint(-2.05F, 3.0F, -3.2F);
			setRotationAngle(jawgear, 0.0F, -0.1745F, 0.0F);
			jawgear2.setRotationPoint(2.05F, 3.0F, -3.2F);
			setRotationAngle(jawgear2, 0.0F, 0.1745F, 0.0F);
			jaw3.setRotationPoint(4.4F, 2.5F, -0.3F);
			setRotationAngle(jaw3, 0.1745F, 0.0F, 0.0F);
			jaw2.setRotationPoint(4.4F, 3.5F, -0.8F);
			setRotationAngle(jaw2, 0.0F, -0.3491F, 0.0F);
			jaw.setRotationPoint(2.0F, 3.5F, -6.0F);
			setRotationAngle(jaw, 0.0F, 0.3491F, 0.0F);
			tail.setRotationPoint(0.0F, -13.0F, 8.0F);
			setRotationAngle(tail, 0.1745F, 0.0F, 0.0F);
			legs.setRotationPoint(3.0F, 0.0F, -4.0F);
			back.setRotationPoint(-3.0F, -8.0F, 11.0F);
			setRotationAngle(back, -0.7854F, 0.0F, 0.0F);
			left.setRotationPoint(1.5F, 0.0F, 0.0F);
			setRotationAngle(left, 0.0F, 0.0F, -0.4363F);
			right.setRotationPoint(-1.5F, 0.0F, 0.0F);
			setRotationAngle(right, 0.0F, 0.0F, 0.4363F);
			front.setRotationPoint(0.0F, 0.0F, 0.0F);
			left2.setRotationPoint(-0.5F, -7.2929F, 0.7071F);
			setRotationAngle(left2, 0.6109F, 0.0F, 0.0F);
			kneeplate.setRotationPoint(0.5F, 8.0F, 0.0F);
			right2.setRotationPoint(-5.5F, -7.2929F, 0.7071F);
			setRotationAngle(right2, 0.6109F, 0.0F, 0.0F);
			kneeplate2.setRotationPoint(0.5F, 8.0F, 0.0F);
			sholderplate.setRotationPoint(-3.0F, -10.8F, 0.4F);
			setRotationAngle(sholderplate, -0.3491F, 0.0F, 0.0F);
			
			
			
			}
			else if(entityIn.isSleeping()) {
				body.setRotationPoint(0.0F, 31.0F, 0.0F);
				mane.setRotationPoint(1.0F, -14.0F, 2.0F);
				Mainbody.setRotationPoint(3.0F, -8.0F, 0.0F);
				gearsL.setRotationPoint(0.0F, 0.0F, 0.0F);
				gear1.setRotationPoint(0.0F, 0.0F, 0.0F);
				Layer5.setRotationPoint(0.0F, 0.0F, 0.0F);
				layer6.setRotationPoint(0.4F, -1.8F, 1.6F);
				setRotationAngle(layer6, -0.7854F, 0.0F, 0.0F);
				gear2.setRotationPoint(0.3F, -2.4F, 4.0F);
				Layer7.setRotationPoint(-0.3F, 1.8F, -1.6F);
				layer8.setRotationPoint(0.1F, 0.0F, 0.0F);
				setRotationAngle(layer8, -0.7854F, 0.0F, 0.0F);
				gearsR.setRotationPoint(0.0F, 0.0F, 0.0F);
				gear4.setRotationPoint(-6.0F, -0.6F, 2.4F);
				Layer4.setRotationPoint(0.0F, 0.0F, 0.0F);
				layer9.setRotationPoint(-0.4F, -1.8F, 1.6F);
				setRotationAngle(layer9, -0.7854F, 0.0F, 0.0F);
				gear3.setRotationPoint(-6.0F, 0.0F, 0.0F);
				Layer2.setRotationPoint(0.0F, 0.0F, 0.0F);
				layer3.setRotationPoint(-0.4F, -1.8F, 1.6F);
				setRotationAngle(layer3, -0.7854F, 0.0F, 0.0F);
				head.setRotationPoint(0.0F, -14.0F, -6.0F);
				jawgear2.setRotationPoint(2.05F, 3.0F, -3.2F);
				setRotationAngle(jawgear2, 0.0F, 0.1745F, 0.0F);
				jaw3.setRotationPoint(4.4F, 2.5F, -0.3F);
				setRotationAngle(jaw3, 0.1745F, 0.0F, 0.0F);
				jaw2.setRotationPoint(4.4F, 3.5F, -0.8F);
				setRotationAngle(jaw2, 0.0F, -0.3491F, 0.0F);
				jaw.setRotationPoint(2.0F, 3.5F, -6.0F);
				setRotationAngle(jaw, 0.0F, 0.3491F, 0.0F);
				tail.setRotationPoint(0.0F, -13.0F, 8.0F);
				setRotationAngle(tail, -0.5236F, 0.0F, 0.0F);
				legs.setRotationPoint(3.0F, 0.0F, -4.0F);
				back.setRotationPoint(-3.0F, -8.0F, 11.0F);
				setRotationAngle(back, 1.5708F, 0.0F, 0.0F);
				left.setRotationPoint(1.5F, 0.0F, 0.0F);
				right.setRotationPoint(-1.5F, 0.0F, 0.0F);
				front.setRotationPoint(-3.0F, -8.0F, 0.0F);
				left2.setRotationPoint(2.5F, 0.0F, 0.0F);
				setRotationAngle(left2, -1.4835F, 0.0F, 0.0F);
				kneeplate.setRotationPoint(0.5F, 8.0F, 0.0F);
				right2.setRotationPoint(-2.5F, 0.0F, 0.0F);
				setRotationAngle(right2, -1.4835F, 0.0F, 0.0F);
				kneeplate2.setRotationPoint(0.5F, 8.0F, 0.0F);
				sholderplate.setRotationPoint(0.0F, -2.8F, 0.4F);
				setRotationAngle(sholderplate, -0.3491F, 0.0F, 0.0F);
				
				
			}
			else if(false){
				body.setRotationPoint(0.0F, 31.0F, 0.0F);
		    	setRotationAngle(body, 0.0F, 0.0F, 0.0F);
		    	mane.setRotationPoint(1.0F, -14.0F, 2.0F);
		    	Mainbody.setRotationPoint(3.0F, -8.0F, 0.0F);
		    	gearsL.setRotationPoint(0.0F, 0.0F, 0.0F);
		    	
				gearsR.setRotationPoint(0.0F, 0.0F, 0.0F);
				
				head.setRotationPoint(0.0F, -14.0F, -6.0F);
				jawgear.setRotationPoint(-2.05F, 3.0F, -3.2F);
				setRotationAngle(jawgear, 0.0F, -0.1745F, 0.0F);
				jawgear2.setRotationPoint(2.05F, 3.0F, -3.2F);
				setRotationAngle(jawgear2, 0.0F, 0.1745F, 0.0F);
				jaw3.setRotationPoint(4.4F, 2.5F, -0.3F);
				setRotationAngle(jaw3, 0.1745F, 0.0F, 0.0F);
				jaw2.setRotationPoint(4.4F, 3.5F, -0.8F);
				setRotationAngle(jaw2, 0.0F, -0.3491F, 0.0F);
				jaw.setRotationPoint(2.0F, 3.5F, -6.0F);
				setRotationAngle(jaw, 0.0F, 0.3491F, 0.0F);
				tail.setRotationPoint(0.0F, -13.0F, 8.0F);
				setRotationAngle(tail, -0.5236F, 0.0F, 0.0F);
				legs.setRotationPoint(3.0F, 0.0F, -4.0F);
				back.setRotationPoint(-3.0F, -8.0F, 11.0F);
				setRotationAngle(back, 1.5708F, 0.0F, 0.0F);
				left.setRotationPoint(1.5F, 0.0F, 0.0F);
				right.setRotationPoint(-1.5F, 0.0F, 0.0F);
				front.setRotationPoint(-3.0F, -8.0F, 0.0F);
				left2.setRotationPoint(2.5F, 0.0F, 0.0F);
				setRotationAngle(left2, -1.4835F, 0.0F, 0.0F);
				kneeplate.setRotationPoint(0.5F, 8.0F, 0.0F);
				right2.setRotationPoint(-2.5F, 0.0F, 0.0F);
				setRotationAngle(right2, -1.4835F, 0.0F, 0.0F);
				kneeplate2.setRotationPoint(0.5F, 8.0F, 0.0F);
				sholderplate.setRotationPoint(0.0F, -2.8F, 0.4F);
				setRotationAngle(sholderplate, -0.3491F, 0.0F, 0.0F);
				
			}else {
	    	  setRotationAngle(body, 0.0F, 0.0F, 0.0F);
	    	  setRotationAngle(mane, 0.0F, 0.0F, 0.0F);
	    	  setRotationAngle(head, 0.0F, 0.0F, 0.0F);
	    	  //this.tail.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.2F);
	    	  setRotationAngle(back, 0.0F, 0.0F, 0.0F);
	    	  setRotationAngle(left, 0.0F, 0.0F, 0.0F);
	    	  setRotationAngle(right, 0.0F, 0.0F, 0.0F);
	    	  setRotationAngle(left2, 0.0F, 0.0F, 0.0F);
	    	  setRotationAngle(right2, 0.0F, 0.0F, 0.0F);
	    	  body.setRotationPoint(0.0F, 24.0F, -0.0F);
	    	 
	         this.right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	         this.left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	         this.right2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	         this.left2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	      }
        
        //this.head.rotateAngleZ = entityIn.getInterestedAngle(partialTick) + entityIn.getShakeAngle(partialTick, 0.0F);
        //this.mane.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.08F);
        //this.Mainbody.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.16F);
        //this.tail.rotateAngleZ = entityIn.getShakeAngle(partialTick, -0.2F);
        //this.gear1.rotateAngleX = partialTick;
        //this.gear2.rotateAngleX = partialTick;
        //this.gear3.rotateAngleX = partialTick;
        //this.gear4.rotateAngleX = partialTick;
	   }
}