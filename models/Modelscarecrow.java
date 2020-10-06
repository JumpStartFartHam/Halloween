// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelscarecrow extends EntityModel<Entity> {
	private final ModelRenderer scarecrow;
	private final ModelRenderer head;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;

	public Modelscarecrow() {
		textureWidth = 128;
		textureHeight = 128;

		scarecrow = new ModelRenderer(this);
		scarecrow.setRotationPoint(0.0F, 24.0F, 0.0F);
		scarecrow.setTextureOffset(0, 32).addBox(-8.0F, -32.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		scarecrow.setTextureOffset(60, 60).addBox(-2.0F, -16.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -32.0F, 0.0F);
		scarecrow.addChild(head);
		head.setTextureOffset(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-8.0F, -30.0F, 0.0F);
		scarecrow.addChild(rightarm);
		setRotationAngle(rightarm, 0.0F, 3.1416F, 0.0F);
		rightarm.setTextureOffset(0, 5).addBox(0.0F, 5.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		rightarm.setTextureOffset(60, 28).addBox(6.0F, -2.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(8.0F, -30.0F, 0.0F);
		scarecrow.addChild(leftarm);
		leftarm.setTextureOffset(0, 10).addBox(0.0F, 5.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		leftarm.setTextureOffset(0, 32).addBox(0.0F, -1.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		leftarm.setTextureOffset(0, 64).addBox(6.0F, -2.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		scarecrow.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}