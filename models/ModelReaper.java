// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelReaper extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer hood1;
	private final ModelRenderer hood2;
	private final ModelRenderer hood3;
	private final ModelRenderer hood4;
	private final ModelRenderer neck;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightarmupper;
	private final ModelRenderer rightarmlower;
	private final ModelRenderer scythe;
	private final ModelRenderer scythe1;
	private final ModelRenderer scythe2;
	private final ModelRenderer scythe3;
	private final ModelRenderer scythe4;
	private final ModelRenderer scythe5;
	private final ModelRenderer staff;
	private final ModelRenderer leftarm;
	private final ModelRenderer leftarmupper;
	private final ModelRenderer leftarmlower;
	private final ModelRenderer body;
	private final ModelRenderer torso1;
	private final ModelRenderer torso2;
	private final ModelRenderer torso3;
	private final ModelRenderer torso4;

	public ModelReaper() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -2.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

		hood1 = new ModelRenderer(this);
		hood1.setRotationPoint(-5.0F, -11.0F, -5.0F);
		head.addChild(hood1);
		hood1.setTextureOffset(32, 0).addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, true);

		hood2 = new ModelRenderer(this);
		hood2.setRotationPoint(-4.0F, -12.0F, 4.0F);
		head.addChild(hood2);
		hood2.setTextureOffset(72, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 3.0F, 0.0F, true);

		hood3 = new ModelRenderer(this);
		hood3.setRotationPoint(-3.0F, -13.0F, 6.0F);
		head.addChild(hood3);
		hood3.setTextureOffset(94, 0).addBox(0.0F, 0.0F, 0.0F, 6.0F, 4.0F, 3.0F, 0.0F, true);

		hood4 = new ModelRenderer(this);
		hood4.setRotationPoint(-2.0F, -14.0F, 7.0F);
		head.addChild(hood4);
		hood4.setTextureOffset(112, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 4.0F, 0.0F, true);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(-1.0F, -1.0F, -1.0F);
		head.addChild(neck);
		neck.setTextureOffset(8, 16).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-10.0F, 0.0F, 0.0F);

		rightarmupper = new ModelRenderer(this);
		rightarmupper.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarm.addChild(rightarmupper);
		setRotationAngle(rightarmupper, -0.3655F, 0.147F, 0.3655F);
		rightarmupper.setTextureOffset(0, 77).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);

		rightarmlower = new ModelRenderer(this);
		rightarmlower.setRotationPoint(-1.0F, 11.0F, 0.0F);
		rightarmupper.addChild(rightarmlower);
		setRotationAngle(rightarmlower, -0.7854F, 0.0F, -0.3927F);
		rightarmlower.setTextureOffset(0, 92).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);

		scythe = new ModelRenderer(this);
		scythe.setRotationPoint(0.0F, 13.0F, 6.0F);
		rightarmlower.addChild(scythe);
		setRotationAngle(scythe, 1.5708F, 0.0F, 0.0F);

		scythe1 = new ModelRenderer(this);
		scythe1.setRotationPoint(-1.0F, -36.0F, -7.0F);
		scythe.addChild(scythe1);
		scythe1.setTextureOffset(50, 35).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 8.0F, 0.0F, true);

		scythe2 = new ModelRenderer(this);
		scythe2.setRotationPoint(-1.0F, -34.0F, -8.0F);
		scythe.addChild(scythe2);
		scythe2.setTextureOffset(50, 49).addBox(0.0F, 0.0F, -1.0F, 3.0F, 6.0F, 2.0F, 0.0F, true);

		scythe3 = new ModelRenderer(this);
		scythe3.setRotationPoint(-1.0F, -32.0F, -9.0F);
		scythe.addChild(scythe3);
		scythe3.setTextureOffset(60, 49).addBox(0.0F, 0.0F, -2.0F, 3.0F, 6.0F, 2.0F, 0.0F, true);

		scythe4 = new ModelRenderer(this);
		scythe4.setRotationPoint(-1.0F, -30.0F, -10.0F);
		scythe.addChild(scythe4);
		scythe4.setTextureOffset(50, 57).addBox(0.0F, 0.0F, -3.0F, 3.0F, 6.0F, 2.0F, 0.0F, true);

		scythe5 = new ModelRenderer(this);
		scythe5.setRotationPoint(-1.0F, -28.0F, -10.0F);
		scythe.addChild(scythe5);
		scythe5.setTextureOffset(60, 57).addBox(0.0F, 0.0F, -4.0F, 3.0F, 6.0F, 1.0F, 0.0F, true);

		staff = new ModelRenderer(this);
		staff.setRotationPoint(-1.0F, -32.0F, -2.0F);
		scythe.addChild(staff);
		staff.setTextureOffset(72, 20).addBox(0.0F, 2.0F, 0.0F, 3.0F, 30.0F, 3.0F, 0.0F, true);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(10.0F, 0.0F, 0.0F);
		setRotationAngle(leftarm, 0.0F, 0.0F, -0.3927F);

		leftarmupper = new ModelRenderer(this);
		leftarmupper.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(leftarmupper);
		setRotationAngle(leftarmupper, -0.3927F, 0.0F, 0.0F);
		leftarmupper.setTextureOffset(0, 77).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);

		leftarmlower = new ModelRenderer(this);
		leftarmlower.setRotationPoint(1.0F, 11.0F, 0.0F);
		leftarmupper.addChild(leftarmlower);
		setRotationAngle(leftarmlower, -0.7854F, 0.0F, 0.3927F);
		leftarmlower.setTextureOffset(0, 92).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);

		torso1 = new ModelRenderer(this);
		torso1.setRotationPoint(-10.0F, -25.0F, -4.0F);
		body.addChild(torso1);
		setRotationAngle(torso1, 0.2231F, 0.0F, 0.0F);
		torso1.setTextureOffset(0, 20).addBox(0.0F, 0.0F, 0.0F, 20.0F, 7.0F, 8.0F, 0.0F, true);

		torso2 = new ModelRenderer(this);
		torso2.setRotationPoint(-8.0F, -18.0F, -2.0F);
		body.addChild(torso2);
		setRotationAngle(torso2, 0.5205F, 0.0F, 0.0F);
		torso2.setTextureOffset(0, 35).addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 7.0F, 0.0F, true);

		torso3 = new ModelRenderer(this);
		torso3.setRotationPoint(-5.0F, -10.0F, 3.0F);
		body.addChild(torso3);
		setRotationAngle(torso3, 1.041F, 0.0F, 0.0F);
		torso3.setTextureOffset(0, 51).addBox(0.0F, 0.0F, 0.0F, 10.0F, 9.0F, 5.0F, 0.0F, true);

		torso4 = new ModelRenderer(this);
		torso4.setRotationPoint(-3.0F, -6.0F, 11.0F);
		body.addChild(torso4);
		setRotationAngle(torso4, 1.3384F, 0.0F, 0.0F);
		torso4.setTextureOffset(0, 65).addBox(0.0F, 0.0F, 0.0F, 6.0F, 9.0F, 3.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}