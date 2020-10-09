// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelvampire_bat extends EntityModel<Entity> {
	private final ModelRenderer bat;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightEar;
	private final ModelRenderer leftEar;
	private final ModelRenderer rightWing;
	private final ModelRenderer rightWingTip;
	private final ModelRenderer leftWing;
	private final ModelRenderer leftWingTip;

	public Modelvampire_bat() {
		textureWidth = 64;
		textureHeight = 64;

		bat = new ModelRenderer(this);
		bat.setRotationPoint(0.0F, 24.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -14.0F, 0.0F);
		bat.addChild(body);
		setRotationAngle(body, 0.7854F, 0.0F, 0.0F);
		body.setTextureOffset(0, 16).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, true);
		body.setTextureOffset(0, 34).addBox(-5.0F, 6.0F, 0.0F, 10.0F, 16.0F, 1.0F, 0.0F, true);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -9.0F, 0.0F);
		body.addChild(head);
		setRotationAngle(head, -0.7854F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);

		rightEar = new ModelRenderer(this);
		rightEar.setRotationPoint(0.0F, -1.0F, 0.0F);
		head.addChild(rightEar);
		rightEar.setTextureOffset(24, 0).addBox(1.0F, -5.0F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		leftEar = new ModelRenderer(this);
		leftEar.setRotationPoint(0.0F, -1.0F, 0.0F);
		head.addChild(leftEar);
		leftEar.setTextureOffset(24, 0).addBox(-4.0F, -5.0F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		rightWing = new ModelRenderer(this);
		rightWing.setRotationPoint(2.0F, -1.0F, 2.0F);
		body.addChild(rightWing);
		rightWing.setTextureOffset(42, 0).addBox(0.0F, -8.0F, -0.5F, 10.0F, 16.0F, 1.0F, 0.0F, true);

		rightWingTip = new ModelRenderer(this);
		rightWingTip.setRotationPoint(10.0F, -8.0F, -0.5F);
		rightWing.addChild(rightWingTip);
		rightWingTip.setTextureOffset(24, 16).addBox(0.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F, 0.0F, true);

		leftWing = new ModelRenderer(this);
		leftWing.setRotationPoint(-2.0F, -1.0F, 2.0F);
		body.addChild(leftWing);
		leftWing.setTextureOffset(42, 0).addBox(-10.0F, -8.0F, -0.5F, 10.0F, 16.0F, 1.0F, 0.0F, false);

		leftWingTip = new ModelRenderer(this);
		leftWingTip.setRotationPoint(-10.0F, -8.0F, -0.5F);
		leftWing.addChild(leftWingTip);
		leftWingTip.setTextureOffset(24, 16).addBox(-8.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bat.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leftWing.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.rightWing.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}