package com.iiitb.model;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class TempTransaction {
	@Id
	private String paymentId;//1
	private double amountPaid;//2
	private String dateOfSettlement;//3             //change it to Date type later
	private double amountActuallySettled;//4
	private double excess;//5
	private String applicantId;//6
	private String source;//7
	private String cohort;//8
	private String financialYear;//9
	private String receiptNo;//10
	private String receiptDate;//11                  //change it to Date type later
	private double cgst;//12
	private double sgst;//13
	private double igst;//14
	private double admissionFee;//15
	private double totalValue;//16
	private boolean impMissing;
	
	public TempTransaction() {
		
	}

	public TempTransaction(String paymentId, double amountPaid, String dateOfSettlement, double amountActuallySettled,
			double excess, String applicantId, String source, String cohort, String financialYear, String receiptNo,
			String receiptDate, double cgst, double sgst, double igst, double admissionFee, double totalValue,boolean impMissing) {
		super();
		this.paymentId = paymentId;
		this.amountPaid = amountPaid;
		this.dateOfSettlement = dateOfSettlement;
		this.amountActuallySettled = amountActuallySettled;
		this.excess = excess;
		this.applicantId = applicantId;
		this.source = source;
		this.cohort = cohort;
		this.financialYear = financialYear;
		this.receiptNo = receiptNo;
		this.receiptDate = receiptDate;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.admissionFee = admissionFee;
		this.totalValue = totalValue;
		this.impMissing = impMissing;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getDateOfSettlement() {
		return dateOfSettlement;
	}

	public void setDateOfSettlement(String dateOfSettlement) {
		this.dateOfSettlement = dateOfSettlement;
	}

	public double getAmountActuallySettled() {
		return amountActuallySettled;
	}

	public void setAmountActuallySettled(double amountActuallySettled) {
		this.amountActuallySettled = amountActuallySettled;
	}

	public double getExcess() {
		return excess;
	}

	public void setExcess(double excess) {
		this.excess = excess;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getAdmissionFee() {
		return admissionFee;
	}

	public void setAdmissionFee(double admissionFee) {
		this.admissionFee = admissionFee;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public boolean getImpMissing() {
		return impMissing;
	}

	public void setImpMissing(boolean impMissing) {
		this.impMissing = impMissing;
	}
}
