// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelwolfman extends EntityModel<Entity> {
	private final ModelRenderer wolfman;
	private final ModelRenderer head;
	private final ModelRenderer WolfHead;
	private final ModelRenderer Ear1;
	private final ModelRenderer Ear2;
	private final ModelRenderer Nose;
	private final ModelRenderer body;
	private final ModelRenderer torso;
	private final ModelRenderer mane;
	private final ModelRenderer tail;
	private final ModelRenderer leftarm;
	private final ModelRenderer larm;
	private final ModelRenderer rightarm;
	private final ModelRenderer rarm;
	private final ModelRenderer leftleg;
	private final ModelRenderer lleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer rleg;

	public Modelwolfman() {
		textureWidth = 64;
		textureHeight = 64;

		wolfman = new ModelRenderer(this);
		wolfman.setRotationPoint(1.0F, 24.0F, -1.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(-1.0F, -23.0F, -3.0F);
		wolfman.addChild(head);

		WolfHead = new ModelRenderer(this);
		WolfHead.setRotationPoint(-4.0F, -4.0F, -5.0F);
		head.addChild(WolfHead);
		WolfHead.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 6.0F, 0.0F, true);

		Ear1 = new ModelRenderer(this);
		Ear1.setRotationPoint(-4.0F, -6.5F, -4.0F);
		head.addChild(Ear1);
		Ear1.setTextureOffset(32, 15).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);

		Ear2 = new ModelRenderer(this);
		Ear2.setRotationPoint(1.0F, -6.5F, -4.0F);
		head.addChild(Ear2);
		Ear2.setTextureOffset(32, 15).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);

		Nose = new ModelRenderer(this);
		Nose.setRotationPoint(-2.5F, 0.0F, -8.0F);
		head.addChild(Nose);
		Nose.setTextureOffset(44, 15).addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 5.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		wolfman.addChild(body);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(-5.0F, -22.0F, -4.0F);
		body.addChild(torso);
		setRotationAngle(torso, 0.2603F, 0.0F, 0.0F);
		torso.setTextureOffset(20, 30).addBox(0.0F, 0.0F, 0.0F, 8.0F, 12.0F, 6.0F, 0.0F, true);

		mane = new ModelRenderer(this);
		mane.setRotationPoint(-5.0F, -19.0F, -6.0F);
		body.addChild(mane);
		setRotationAngle(mane, 1.0131F, 0.0F, 0.0F);
		mane.setTextureOffset(30, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 8.0F, 0.0F, true);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-2.0F, -12.0F, 3.0F);
		body.addChild(tail);
		setRotationAngle(tail, 0.8727F, 0.0F, 0.0F);
		tail.setTextureOffset(26, 53).addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(3.0F, -21.0F, -2.0F);
		wolfman.addChild(leftarm);

		larm = new ModelRenderer(this);
		larm.setRotationPoint(2.0F, 0.0F, 0.0F);
		leftarm.addChild(larm);
		setRotationAngle(larm, -0.1396F, 0.0F, 0.0F);
		larm.setTextureOffset(0, 18).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-5.0F, -21.0F, -2.0F);
		wolfman.addChild(rightarm);

		rarm = new ModelRenderer(this);
		rarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarm.addChild(rarm);
		setRotationAngle(rarm, -0.1396F, 0.0F, 0.0F);
		rarm.setTextureOffset(0, 18).addBox(-4.0F, -0.7119F, -2.1197F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(1.0F, -12.0F, 1.5F);
		wolfman.addChild(leftleg);

		lleg = new ModelRenderer(this);
		lleg.setRotationPoint(-2.0F, 0.0F, -2.5F);
		leftleg.addChild(lleg);
		lleg.setTextureOffset(0, 47).addBox(0.0F, 0.0F, 0.0F, 4.0F, 12.0F, 5.0F, 0.0F, true);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		wolfman.addChild(rightleg);

		rleg = new ModelRenderer(this);
		rleg.setRotationPoint(-3.0F, -12.0F, 1.5F);
		rightleg.addChild(rleg);
		rleg.setTextureOffset(0, 47).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 12.0F, 5.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		wolfman.render(matrixStack, buffer, packedLight, packedOverlay);
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