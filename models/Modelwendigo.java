// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelwendigo extends EntityModel<Entity> {
	private final ModelRenderer wendigo;
	private final ModelRenderer torso;
	private final ModelRenderer lowerbody;
	private final ModelRenderer head;
	private final ModelRenderer muzzle;
	private final ModelRenderer rightear;
	private final ModelRenderer leftear;
	private final ModelRenderer chin;
	private final ModelRenderer antler1;
	private final ModelRenderer antler2;
	private final ModelRenderer antler3;
	private final ModelRenderer antler4;
	private final ModelRenderer antler5;
	private final ModelRenderer antler6;
	private final ModelRenderer antler7;
	private final ModelRenderer antler8;
	private final ModelRenderer antler9;
	private final ModelRenderer antler10;
	private final ModelRenderer antler11;
	private final ModelRenderer antler12;
	private final ModelRenderer neck;
	private final ModelRenderer leftarm;
	private final ModelRenderer leftarmupper;
	private final ModelRenderer leftbicep;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightarmupper;
	private final ModelRenderer rightbicep;
	private final ModelRenderer rightleg;
	private final ModelRenderer rightlegupper;
	private final ModelRenderer rightknee;
	private final ModelRenderer rightthigh;
	private final ModelRenderer righthoof;
	private final ModelRenderer leftleg;
	private final ModelRenderer leftlegupper;
	private final ModelRenderer leftthigh;
	private final ModelRenderer leftknee;
	private final ModelRenderer lefthoof;

	public Modelwendigo() {
		textureWidth = 256;
		textureHeight = 256;

		wendigo = new ModelRenderer(this);
		wendigo.setRotationPoint(-4.0F, -1.0F, 0.0F);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(3.0F, -18.5F, -3.0F);
		wendigo.addChild(torso);
		setRotationAngle(torso, 0.2618F, 0.0F, 0.0F);
		torso.setTextureOffset(16, 81).addBox(-4.0F, 0.0F, -2.0F, 10.0F, 10.0F, 5.0F, 0.0F, true);

		lowerbody = new ModelRenderer(this);
		lowerbody.setRotationPoint(0.0F, 8.9824F, 1.0681F);
		torso.addChild(lowerbody);
		setRotationAngle(lowerbody, -0.2618F, 0.0F, 0.0F);
		lowerbody.setTextureOffset(16, 100).addBox(-4.0F, 0.0F, -2.0F, 10.0F, 10.0F, 4.0F, 0.0F, true);

		head = new ModelRenderer(this);
		head.setRotationPoint(4.0F, -18.0F, -2.0F);
		wendigo.addChild(head);
		head.setTextureOffset(0, 22).addBox(-4.0F, -5.0F, -11.0F, 8.0F, 7.0F, 8.0F, 0.0F, true);

		muzzle = new ModelRenderer(this);
		muzzle.setRotationPoint(1.0F, 6.0F, -11.0F);
		head.addChild(muzzle);
		muzzle.setTextureOffset(0, 40).addBox(-4.0F, -8.0F, -4.0F, 6.0F, 4.0F, 4.0F, 0.0F, true);

		rightear = new ModelRenderer(this);
		rightear.setRotationPoint(-1.0F, 4.0F, -6.0F);
		head.addChild(rightear);
		rightear.setTextureOffset(48, 0).addBox(-4.0F, -8.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, true);

		leftear = new ModelRenderer(this);
		leftear.setRotationPoint(8.0F, 4.0F, -6.0F);
		head.addChild(leftear);
		leftear.setTextureOffset(36, 0).addBox(-4.0F, -8.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, true);

		chin = new ModelRenderer(this);
		chin.setRotationPoint(2.0F, 10.0F, -10.0F);
		head.addChild(chin);
		chin.setTextureOffset(0, 64).addBox(-4.0F, -8.0F, -4.0F, 4.0F, 1.0F, 11.0F, 0.0F, true);

		antler1 = new ModelRenderer(this);
		antler1.setRotationPoint(1.6F, -6.0F, -9.0F);
		head.addChild(antler1);
		antler1.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		antler2 = new ModelRenderer(this);
		antler2.setRotationPoint(3.0F, -9.0F, -5.0F);
		head.addChild(antler2);
		setRotationAngle(antler2, -0.9599F, 0.3491F, 0.0F);
		antler2.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);

		antler3 = new ModelRenderer(this);
		antler3.setRotationPoint(3.0F, -14.0F, -1.0F);
		head.addChild(antler3);
		setRotationAngle(antler3, -0.7369F, 0.0F, 0.0F);
		antler3.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, true);

		antler4 = new ModelRenderer(this);
		antler4.setRotationPoint(-2.7F, -6.0F, -9.0F);
		head.addChild(antler4);
		antler4.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		antler5 = new ModelRenderer(this);
		antler5.setRotationPoint(-4.0F, -9.0F, -5.0F);
		head.addChild(antler5);
		setRotationAngle(antler5, -0.9599F, -0.3491F, 0.0F);
		antler5.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);

		antler6 = new ModelRenderer(this);
		antler6.setRotationPoint(2.8F, -19.5F, 0.0F);
		head.addChild(antler6);
		setRotationAngle(antler6, -0.2329F, -0.2974F, 0.0F);
		antler6.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, true);

		antler7 = new ModelRenderer(this);
		antler7.setRotationPoint(-2.0F, -17.0F, -1.0F);
		head.addChild(antler7);
		setRotationAngle(antler7, 0.0067F, 0.0F, 0.5205F);
		antler7.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		antler8 = new ModelRenderer(this);
		antler8.setRotationPoint(-7.5F, -15.0F, 3.0F);
		head.addChild(antler8);
		setRotationAngle(antler8, -0.7534F, 0.0F, -1.0136F);
		antler8.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, true);

		antler9 = new ModelRenderer(this);
		antler9.setRotationPoint(-3.0F, -11.0F, -7.0F);
		head.addChild(antler9);
		setRotationAngle(antler9, 0.4363F, 0.0F, 0.4363F);
		antler9.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		antler10 = new ModelRenderer(this);
		antler10.setRotationPoint(-4.0F, -14.0F, -1.0F);
		head.addChild(antler10);
		setRotationAngle(antler10, -0.6997F, 0.0F, 0.0F);
		antler10.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, true);

		antler11 = new ModelRenderer(this);
		antler11.setRotationPoint(3.0F, -12.0F, 2.0F);
		head.addChild(antler11);
		setRotationAngle(antler11, -1.3854F, 0.0F, 0.0F);
		antler11.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, true);

		antler12 = new ModelRenderer(this);
		antler12.setRotationPoint(5.0F, -16.5F, 4.0F);
		head.addChild(antler12);
		setRotationAngle(antler12, -1.1252F, 0.409F, 0.0F);
		antler12.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, true);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(1.0F, 5.0F, -2.0F);
		head.addChild(neck);
		neck.setTextureOffset(0, 50).addBox(-4.0F, -8.0F, -4.0F, 6.0F, 4.0F, 8.0F, 0.0F, true);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(9.5F, -17.0F, -2.0F);
		wendigo.addChild(leftarm);

		leftarmupper = new ModelRenderer(this);
		leftarmupper.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(leftarmupper);
		setRotationAngle(leftarmupper, -0.5236F, 0.0F, 0.0F);
		leftarmupper.setTextureOffset(224, 23).addBox(3.0F, 11.1244F, 3.2679F, 3.0F, 18.0F, 2.0F, 0.0F, true);

		leftbicep = new ModelRenderer(this);
		leftbicep.setRotationPoint(2.5F, -1.4614F, 0.4395F);
		leftarmupper.addChild(leftbicep);
		setRotationAngle(leftbicep, 0.384F, 0.0F, -0.2618F);
		leftbicep.setTextureOffset(224, 2).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 16.0F, 2.0F, 0.0F, true);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-1.5F, -17.0F, -2.0F);
		wendigo.addChild(rightarm);

		rightarmupper = new ModelRenderer(this);
		rightarmupper.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightarm.addChild(rightarmupper);
		setRotationAngle(rightarmupper, -0.5236F, 0.0F, 0.0F);
		rightarmupper.setTextureOffset(240, 23).addBox(-6.0F, 11.1244F, 3.2679F, 3.0F, 18.0F, 2.0F, 0.0F, true);

		rightbicep = new ModelRenderer(this);
		rightbicep.setRotationPoint(0.5F, -0.4614F, 0.4395F);
		rightarmupper.addChild(rightbicep);
		setRotationAngle(rightbicep, 0.384F, 0.0F, 0.2618F);
		rightbicep.setTextureOffset(240, 2).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 16.0F, 2.0F, 0.0F, true);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		wendigo.addChild(rightleg);

		rightlegupper = new ModelRenderer(this);
		rightlegupper.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightleg.addChild(rightlegupper);
		setRotationAngle(rightlegupper, -0.1745F, 0.0F, 0.0F);
		rightlegupper.setTextureOffset(90, 43).addBox(-2.0F, 10.8329F, -0.0899F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		rightknee = new ModelRenderer(this);
		rightknee.setRotationPoint(-2.0F, 9.8329F, -5.0899F);
		rightlegupper.addChild(rightknee);
		setRotationAngle(rightknee, 1.0472F, 0.0F, 0.0F);
		rightknee.setTextureOffset(90, 26).addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 3.0F, 0.0F, true);

		rightthigh = new ModelRenderer(this);
		rightthigh.setRotationPoint(0.0F, -0.1671F, 0.9101F);
		rightlegupper.addChild(rightthigh);
		setRotationAngle(rightthigh, -0.3491F, 0.0F, 0.0F);
		rightthigh.setTextureOffset(90, 7).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

		righthoof = new ModelRenderer(this);
		righthoof.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightlegupper.addChild(righthoof);
		setRotationAngle(righthoof, 0.1745F, 0.0F, 0.0F);
		righthoof.setTextureOffset(0, 114).addBox(-2.0F, -1.191F, 0.1827F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(8.0F, 0.0F, 0.0F);
		wendigo.addChild(leftleg);

		leftlegupper = new ModelRenderer(this);
		leftlegupper.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftleg.addChild(leftlegupper);
		setRotationAngle(leftlegupper, -0.1745F, 0.0F, 0.0F);
		leftlegupper.setTextureOffset(70, 43).addBox(-2.0F, 10.8329F, -0.0899F, 4.0F, 12.0F, 4.0F, 0.0F, true);

		leftthigh = new ModelRenderer(this);
		leftthigh.setRotationPoint(0.0F, -0.1671F, 0.9101F);
		leftlegupper.addChild(leftthigh);
		setRotationAngle(leftthigh, -0.3491F, 0.0F, 0.0F);
		leftthigh.setTextureOffset(70, 7).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

		leftknee = new ModelRenderer(this);
		leftknee.setRotationPoint(-2.0F, 9.8329F, -5.0899F);
		leftlegupper.addChild(leftknee);
		setRotationAngle(leftknee, 1.0472F, 0.0F, 0.0F);
		leftknee.setTextureOffset(70, 26).addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 3.0F, 0.0F, true);

		lefthoof = new ModelRenderer(this);
		lefthoof.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftlegupper.addChild(lefthoof);
		setRotationAngle(lefthoof, 0.1745F, 0.0F, 0.0F);
		lefthoof.setTextureOffset(16, 114).addBox(-2.0F, -1.191F, 0.1827F, 4.0F, 2.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		wendigo.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}