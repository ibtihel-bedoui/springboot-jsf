package tn.dari.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.dari.entities.Bank;
import tn.dari.entities.Credit;
import tn.dari.service.ICreditService;

@Controller(value = "chartsimulation")
@ELBeanName(value = "chartsimulation")
@Join(path = "/chart", to = "/ChartSimulation.jsf")
@ViewScoped
public class Chart {

	@Autowired
	ICreditService icreditService;
	
	private LineChartModel animatedModel1;
	private LineChartModel animatedModel4;

	private BarChartModel animatedModel2;
	private BarChartModel animatedModel3;
	private BarChartModel animatedModel5;
	private BarChartModel animatedModel6;
	private BarChartModel animatedModel7;
	private BarChartModel animatedModel8;
	private BarChartModel animatedModel9;

	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private PieChartModel pieModel3;
	private PieChartModel pieModel4;
	private PieChartModel pieModel5;
	
	public ICreditService getIcreditService() {
		return icreditService;
	}

	public void setIcreditService(ICreditService icreditService) {
		this.icreditService = icreditService;
	}

	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	public void setAnimatedModel1(LineChartModel animatedModel1) {
		this.animatedModel1 = animatedModel1;
	}

	public LineChartModel getAnimatedModel4() {
		return animatedModel4;
	}

	public void setAnimatedModel4(LineChartModel animatedModel4) {
		this.animatedModel4 = animatedModel4;
	}

	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	public void setAnimatedModel2(BarChartModel animatedModel2) {
		this.animatedModel2 = animatedModel2;
	}

	public BarChartModel getAnimatedModel3() {
		return animatedModel3;
	}

	public void setAnimatedModel3(BarChartModel animatedModel3) {
		this.animatedModel3 = animatedModel3;
	}

	public BarChartModel getAnimatedModel5() {
		return animatedModel5;
	}

	public void setAnimatedModel5(BarChartModel animatedModel5) {
		this.animatedModel5 = animatedModel5;
	}

	public BarChartModel getAnimatedModel6() {
		return animatedModel6;
	}

	public void setAnimatedModel6(BarChartModel animatedModel6) {
		this.animatedModel6 = animatedModel6;
	}

	public BarChartModel getAnimatedModel7() {
		return animatedModel7;
	}

	public void setAnimatedModel7(BarChartModel animatedModel7) {
		this.animatedModel7 = animatedModel7;
	}

	public BarChartModel getAnimatedModel8() {
		return animatedModel8;
	}

	public void setAnimatedModel8(BarChartModel animatedModel8) {
		this.animatedModel8 = animatedModel8;
	}

	public BarChartModel getAnimatedModel9() {
		return animatedModel9;
	}

	public void setAnimatedModel9(BarChartModel animatedModel9) {
		this.animatedModel9 = animatedModel9;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	public PieChartModel getPieModel3() {
		return pieModel3;
	}

	public void setPieModel3(PieChartModel pieModel3) {
		this.pieModel3 = pieModel3;
	}

	public PieChartModel getPieModel4() {
		return pieModel4;
	}

	public void setPieModel4(PieChartModel pieModel4) {
		this.pieModel4 = pieModel4;
	}

	public PieChartModel getPieModel5() {
		return pieModel5;
	}

	public void setPieModel5(PieChartModel pieModel5) {
		this.pieModel5 = pieModel5;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}
	private List<Bank> banks;
	
	@PostConstruct
	public void init() {

		createAnimatedModels();
	

	}
	
	private void createAnimatedModels() {
		animatedModel1 = initLinearModel();
		animatedModel1.setTitle("Loan Simulations TAEA");
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setLabel("TAEA");
		yAxis.setMin(0);
		yAxis.setMax(0.5);

		animatedModel4 = initLinearModel1();
		animatedModel4.setTitle("Loans Payment");
		animatedModel4.setAnimate(true);
		animatedModel4.setLegendPosition("se");
		Axis yyAxis = animatedModel4.getAxis(AxisType.Y);
		yyAxis.setLabel("Monthly Payment");
		yyAxis.setMin(0);
		yyAxis.setMax(10000);

		animatedModel2 = initBarModel();
		animatedModel2.setTitle("Loan Simulations TAEG - Insurance Included");
		animatedModel2.setSeriesColors("6b89ff");

		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		yAxis = animatedModel2.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(2);
		yAxis.setLabel("TAEG Insurance");

		animatedModel3 = initBarModel1();
		animatedModel3.setTitle("Loan Simulations TAEG - Insurance Excluded");
		animatedModel3.setSeriesColors("99ffa0");

		animatedModel3.setAnimate(true);
		animatedModel3.setLegendPosition("ne");
		yAxis = animatedModel3.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(2);
		yAxis.setLabel("TAEG");

	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		List<Credit> ls = icreditService.getAllCredit();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Montant");

		for (Credit ls1 : ls) {

			amounts.set(ls1.getMontant(), ls1.getTaeg_assurance());
		}
		model.addSeries(amounts);

		return model;

	}

	private BarChartModel initBarModel1() {
		BarChartModel model = new BarChartModel();
		List<Credit> ls = icreditService.getAllCredit();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Amount");

		for (Credit ls1 : ls) {

			amounts.set(ls1.getMontant(), ls1.getTaeg());
		}
		model.addSeries(amounts);

		return model;

	}
	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		List<Credit> ls = icreditService.getAllCredit();
		ChartSeries amounts = new ChartSeries();

		amounts.setLabel("Amount");

		for (Credit ls1 : ls) {

			amounts.set(ls1.getMontant(), ls1.getTaea());
		}
		model.addSeries(amounts);

		return model;
	}

	private LineChartModel initLinearModel1() {
		LineChartModel model = new LineChartModel();

		List<Credit> ls = icreditService.getAllCredit();
		ChartSeries amounts = new ChartSeries();

		amounts.setLabel("Montant");

		for (Credit ls1 : ls) {

			amounts.set(ls1.getMontant(), ls1.getPaiement_mois());
		}
		model.addSeries(amounts);

		return model;
	}
	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	
}
