// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelqueen_spider extends EntityModel<Entity> {
	private final ModelRenderer giantspider;
	private final ModelRenderer head;
	private final ModelRenderer lmandible;
	private final ModelRenderer rmandible;
	private final ModelRenderer lforcep;
	private final ModelRenderer lforceplower;
	private final ModelRenderer rforcep;
	private final ModelRenderer rforceplower;
	private final ModelRenderer body;
	private final ModelRenderer body1;
	private final ModelRenderer body0;
	private final ModelRenderer rightlegs;
	private final ModelRenderer rightleg1;
	private final ModelRenderer rleg1;
	private final ModelRenderer rleglower1;
	private final ModelRenderer rightleg2;
	private final ModelRenderer rleg2;
	private final ModelRenderer rleglower2;
	private final ModelRenderer rightleg3;
	private final ModelRenderer rleg3;
	private final ModelRenderer rleglower3;
	private final ModelRenderer rightleg4;
	private final ModelRenderer rleg4;
	private final ModelRenderer rleglower4;
	private final ModelRenderer leftlegs;
	private final ModelRenderer leftleg1;
	private final ModelRenderer lleg1;
	private final ModelRenderer lleglower1;
	private final ModelRenderer leftleg2;
	private final ModelRenderer lleg2;
	private final ModelRenderer lleglower2;
	private final ModelRenderer leftleg3;
	private final ModelRenderer lleg3;
	private final ModelRenderer lleglower3;
	private final ModelRenderer leftleg4;
	private final ModelRenderer lleg4;
	private final ModelRenderer lleglower4;

	public Modelqueen_spider() {
		textureWidth = 256;
		textureHeight = 256;

		giantspider = new ModelRenderer(this);
		giantspider.setRotationPoint(0.0F, 25.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -13.0F, -10.0F);
		giantspider.addChild(head);
		head.setTextureOffset(0, 44).addBox(-8.0F, -8.0F, -16.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		lmandible = new ModelRenderer(this);
		lmandible.setRotationPoint(4.0F, 4.0F, -16.0F);
		head.addChild(lmandible);
		setRotationAngle(lmandible, 0.0F, 0.0F, -0.3927F);
		lmandible.setTextureOffset(48, 46).addBox(-2.3827F, -2.0761F, -3.0F, 5.0F, 10.0F, 3.0F, 0.0F, false);
		lmandible.setTextureOffset(74, 51).addBox(2.6173F, 0.9239F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		rmandible = new ModelRenderer(this);
		rmandible.setRotationPoint(-4.0F, 4.0F, -16.0F);
		head.addChild(rmandible);
		setRotationAngle(rmandible, 0.0F, 0.0F, 0.3927F);
		rmandible.setTextureOffset(0, 46).addBox(-2.6173F, -2.0761F, -3.0F, 5.0F, 10.0F, 3.0F, 0.0F, false);
		rmandible.setTextureOffset(64, 51).addBox(-4.6173F, 0.9239F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		lforcep = new ModelRenderer(this);
		lforcep.setRotationPoint(8.0F, 1.0F, -8.0F);
		head.addChild(lforcep);
		setRotationAngle(lforcep, 0.0F, 0.0F, -0.3927F);
		lforcep.setTextureOffset(120, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		lforceplower = new ModelRenderer(this);
		lforceplower.setRotationPoint(0.0F, 6.0F, 0.0F);
		lforcep.addChild(lforceplower);
		setRotationAngle(lforceplower, -1.1781F, 0.0F, 0.0F);
		lforceplower.setTextureOffset(120, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		rforcep = new ModelRenderer(this);
		rforcep.setRotationPoint(-8.0F, 1.0F, -8.0F);
		head.addChild(rforcep);
		setRotationAngle(rforcep, 0.0F, 0.0F, 0.3927F);
		rforcep.setTextureOffset(128, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		rforceplower = new ModelRenderer(this);
		rforceplower.setRotationPoint(0.0F, 6.0F, 0.0F);
		rforcep.addChild(rforceplower);
		setRotationAngle(rforceplower, -1.1781F, 0.0F, 0.0F);
		rforceplower.setTextureOffset(128, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		giantspider.addChild(body);

		body1 = new ModelRenderer(this);
		body1.setRotationPoint(0.0F, -9.0F, 9.0F);
		body.addChild(body1);
		body1.setTextureOffset(0, 76).addBox(-10.0F, -12.0F, -3.0F, 20.0F, 16.0F, 4.0F, 0.0F, false);
		body1.setTextureOffset(72, 0).addBox(-10.0F, -12.0F, 25.0F, 20.0F, 16.0F, 4.0F, 0.0F, false);
		body1.setTextureOffset(0, 10).addBox(2.0F, -6.0F, 29.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		body1.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, 29.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		body1.setTextureOffset(0, 0).addBox(-12.0F, -14.0F, 1.0F, 24.0F, 20.0F, 24.0F, 0.0F, false);

		body0 = new ModelRenderer(this);
		body0.setRotationPoint(0.0F, -9.0F, 0.0F);
		body.addChild(body0);
		body0.setTextureOffset(48, 60).addBox(-7.0F, -10.0F, -10.0F, 14.0F, 12.0F, 16.0F, 0.0F, false);

		rightlegs = new ModelRenderer(this);
		rightlegs.setRotationPoint(3.0F, 0.0F, 0.0F);
		giantspider.addChild(rightlegs);

		rightleg1 = new ModelRenderer(this);
		rightleg1.setRotationPoint(-10.0F, -13.0F, -8.0F);
		rightlegs.addChild(rightleg1);

		rleg1 = new ModelRenderer(this);
		rleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg1.addChild(rleg1);
		setRotationAngle(rleg1, -0.6155F, -0.5236F, 0.9553F);
		rleg1.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		rleglower1 = new ModelRenderer(this);
		rleglower1.setRotationPoint(-12.0F, 0.0F, 0.0F);
		rleg1.addChild(rleglower1);
		setRotationAngle(rleglower1, 0.0F, 0.0F, -1.5708F);
		rleglower1.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-10.0F, -13.0F, -4.0F);
		rightlegs.addChild(rightleg2);

		rleg2 = new ModelRenderer(this);
		rleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg2.addChild(rleg2);
		setRotationAngle(rleg2, -0.2849F, -0.274F, 0.8249F);
		rleg2.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		rleglower2 = new ModelRenderer(this);
		rleglower2.setRotationPoint(-12.0F, 0.0F, 0.0F);
		rleg2.addChild(rleglower2);
		setRotationAngle(rleglower2, 0.0F, 0.0F, -1.5708F);
		rleglower2.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		rightleg3 = new ModelRenderer(this);
		rightleg3.setRotationPoint(-10.0F, -13.0F, 0.0F);
		rightlegs.addChild(rightleg3);

		rleg3 = new ModelRenderer(this);
		rleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg3.addChild(rleg3);
		setRotationAngle(rleg3, 0.0F, 0.0F, 0.7854F);
		rleg3.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		rleglower3 = new ModelRenderer(this);
		rleglower3.setRotationPoint(-12.0F, 0.0F, 0.0F);
		rleg3.addChild(rleglower3);
		setRotationAngle(rleglower3, 0.0F, 0.0F, -1.5708F);
		rleglower3.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		rightleg4 = new ModelRenderer(this);
		rightleg4.setRotationPoint(-10.0F, -13.0F, 4.0F);
		rightlegs.addChild(rightleg4);

		rleg4 = new ModelRenderer(this);
		rleg4.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg4.addChild(rleg4);
		setRotationAngle(rleg4, 0.2849F, 0.274F, 0.8249F);
		rleg4.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		rleglower4 = new ModelRenderer(this);
		rleglower4.setRotationPoint(-12.0F, 0.0F, 0.0F);
		rleg4.addChild(rleglower4);
		setRotationAngle(rleglower4, 0.0F, 0.0F, -1.5708F);
		rleglower4.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		leftlegs = new ModelRenderer(this);
		leftlegs.setRotationPoint(-3.0F, 0.0F, 0.0F);
		giantspider.addChild(leftlegs);

		leftleg1 = new ModelRenderer(this);
		leftleg1.setRotationPoint(10.0F, -13.0F, -8.0F);
		leftlegs.addChild(leftleg1);

		lleg1 = new ModelRenderer(this);
		lleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg1.addChild(lleg1);
		setRotationAngle(lleg1, -0.6155F, 0.5236F, -0.9553F);
		lleg1.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		lleglower1 = new ModelRenderer(this);
		lleglower1.setRotationPoint(12.0F, 0.0F, 0.0F);
		lleg1.addChild(lleglower1);
		setRotationAngle(lleglower1, 0.0F, 0.0F, 1.5708F);
		lleglower1.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(10.0F, -13.0F, -4.0F);
		leftlegs.addChild(leftleg2);

		lleg2 = new ModelRenderer(this);
		lleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg2.addChild(lleg2);
		setRotationAngle(lleg2, -0.2849F, 0.274F, -0.8249F);
		lleg2.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		lleglower2 = new ModelRenderer(this);
		lleglower2.setRotationPoint(12.0F, 0.0F, 0.0F);
		lleg2.addChild(lleglower2);
		setRotationAngle(lleglower2, 0.0F, 0.0F, 1.5708F);
		lleglower2.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		leftleg3 = new ModelRenderer(this);
		leftleg3.setRotationPoint(10.0F, -13.0F, 0.0F);
		leftlegs.addChild(leftleg3);

		lleg3 = new ModelRenderer(this);
		lleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg3.addChild(lleg3);
		setRotationAngle(lleg3, 0.0F, 0.0F, -0.7854F);
		lleg3.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		lleglower3 = new ModelRenderer(this);
		lleglower3.setRotationPoint(12.0F, 0.0F, 0.0F);
		lleg3.addChild(lleglower3);
		setRotationAngle(lleglower3, 3.1416F, 0.0F, 1.5708F);
		lleglower3.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);

		leftleg4 = new ModelRenderer(this);
		leftleg4.setRotationPoint(10.0F, -13.0F, 4.0F);
		leftlegs.addChild(leftleg4);

		lleg4 = new ModelRenderer(this);
		lleg4.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg4.addChild(lleg4);
		setRotationAngle(lleg4, 0.2849F, -0.274F, -0.8249F);
		lleg4.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);

		lleglower4 = new ModelRenderer(this);
		lleglower4.setRotationPoint(12.0F, 0.0F, 0.0F);
		lleg4.addChild(lleglower4);
		setRotationAngle(lleglower4, 0.0F, 0.0F, 1.5708F);
		lleglower4.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		giantspider.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightleg4.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.rightleg3.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightleg2.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftleg4.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.leftleg3.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftleg2.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.leftleg1.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rightleg1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}