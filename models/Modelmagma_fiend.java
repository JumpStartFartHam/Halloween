// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelmagma_fiend extends EntityModel<Entity> {
	private final ModelRenderer winged_fiend;
	private final ModelRenderer head;
	private final ModelRenderer snout;
	private final ModelRenderer lhorn1;
	private final ModelRenderer lhorn2;
	private final ModelRenderer lhorn3;
	private final ModelRenderer rhorn1;
	private final ModelRenderer rhorn2;
	private final ModelRenderer rhorn3;
	private final ModelRenderer body;
	private final ModelRenderer torsoupper;
	private final ModelRenderer torsolower;
	private final ModelRenderer lwing;
	private final ModelRenderer rwing;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public Modelmagma_fiend() {
		textureWidth = 256;
		textureHeight = 256;

		winged_fiend = new ModelRenderer(this);
		winged_fiend.setRotationPoint(0.0F, 26.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -44.0F, -10.0F);
		winged_fiend.addChild(head);
		head.setTextureOffset(0, 0).addBox(-7.0F, -14.0F, -9.0F, 14.0F, 14.0F, 14.0F, 0.0F, true);

		snout = new ModelRenderer(this);
		snout.setRotationPoint(-5.0F, -7.0F, -14.0F);
		head.addChild(snout);
		snout.setTextureOffset(58, 17).addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 5.0F, 0.0F, true);

		lhorn1 = new ModelRenderer(this);
		lhorn1.setRotationPoint(4.0F, -16.0F, -8.0F);
		head.addChild(lhorn1);
		lhorn1.setTextureOffset(88, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);

		lhorn2 = new ModelRenderer(this);
		lhorn2.setRotationPoint(5.0F, -17.0F, -7.0F);
		head.addChild(lhorn2);
		lhorn2.setTextureOffset(88, 4).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		lhorn3 = new ModelRenderer(this);
		lhorn3.setRotationPoint(6.0F, -18.0F, -6.0F);
		head.addChild(lhorn3);
		lhorn3.setTextureOffset(88, 10).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		rhorn1 = new ModelRenderer(this);
		rhorn1.setRotationPoint(-7.0F, -16.0F, -8.0F);
		head.addChild(rhorn1);
		rhorn1.setTextureOffset(88, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);

		rhorn2 = new ModelRenderer(this);
		rhorn2.setRotationPoint(-7.0F, -17.0F, -7.0F);
		head.addChild(rhorn2);
		rhorn2.setTextureOffset(88, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		rhorn3 = new ModelRenderer(this);
		rhorn3.setRotationPoint(-7.0F, -18.0F, -6.0F);
		head.addChild(rhorn3);
		rhorn3.setTextureOffset(88, 10).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(4.0F, -60.0F, -18.0F);
		winged_fiend.addChild(body);

		torsoupper = new ModelRenderer(this);
		torsoupper.setRotationPoint(-13.0F, 19.0F, 4.0F);
		body.addChild(torsoupper);
		setRotationAngle(torsoupper, 0.6109F, 0.0F, 0.0F);
		torsoupper.setTextureOffset(0, 29).addBox(0.0F, 0.0F, 0.0F, 18.0F, 12.0F, 10.0F, 0.0F, true);

		torsolower = new ModelRenderer(this);
		torsolower.setRotationPoint(-12.0F, 26.0F, 11.0F);
		body.addChild(torsolower);
		setRotationAngle(torsolower, 0.2618F, 0.0F, 0.0F);
		torsolower.setTextureOffset(0, 52).addBox(0.0F, 0.0F, 0.0F, 16.0F, 12.0F, 8.0F, 0.0F, true);

		lwing = new ModelRenderer(this);
		lwing.setRotationPoint(-3.0F, 9.0F, 9.0F);
		body.addChild(lwing);
		setRotationAngle(lwing, 0.6109F, -0.3491F, -0.2618F);
		lwing.setTextureOffset(0, 222).addBox(0.0F, 0.0F, 0.0F, 52.0F, 34.0F, 0.0F, 0.0F, true);

		rwing = new ModelRenderer(this);
		rwing.setRotationPoint(-52.0F, -4.0F, 26.0F);
		body.addChild(rwing);
		setRotationAngle(rwing, 0.6109F, 0.3491F, 0.2618F);
		rwing.setTextureOffset(152, 222).addBox(0.0F, 0.0F, 0.0F, 52.0F, 34.0F, 0.0F, 0.0F, true);

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(-7.0F, 33.0F, 22.0F);
		body.addChild(tail1);
		setRotationAngle(tail1, -0.8727F, 0.0F, 0.0F);
		tail1.setTextureOffset(104, 0).addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 20.0F, 0.0F, true);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(-6.0F, 47.0F, 32.0F);
		body.addChild(tail2);
		setRotationAngle(tail2, -0.3604F, 0.0F, 0.0F);
		tail2.setTextureOffset(156, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 5.0F, 20.0F, 0.0F, true);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-9.0F, -43.0F, -8.0F);
		winged_fiend.addChild(rightarm);
		rightarm.setTextureOffset(68, 42).addBox(-6.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, true);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(9.0F, -43.0F, -8.0F);
		winged_fiend.addChild(leftarm);
		leftarm.setTextureOffset(93, 42).addBox(0.0F, -1.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, true);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-5.0F, -24.0F, 0.0F);
		winged_fiend.addChild(rightleg);
		rightleg.setTextureOffset(32, 74).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 22.0F, 8.0F, 0.0F, true);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(5.0F, -24.0F, 0.0F);
		winged_fiend.addChild(leftleg);
		leftleg.setTextureOffset(0, 74).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 22.0F, 8.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		winged_fiend.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}