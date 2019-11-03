package com.iiitb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction{
	@Id
	private String paymentId;
	private double amountPaid;
	private String dateOfSettlement;             //change it to Date type later
	private double amountActuallySettled;
	private double excess;
	private String applicantId;
	private String source;
	private String cohort;
	private String financialYear;
	private String receiptNo;
	private String receiptDate;                  //change it to Date type later
	private double cgst;
	private double sgst;
	private double igst;
	private double admissionFee;
	private double totalValue;
	
	public Transaction() {
		
	}

	public Transaction(String paymentId, double amountPaid, String dateOfSettlement, double amountActuallySettled,
			double excess, String applicantId, String source, String cohort, String financialYear, String receiptNo,
			String receiptDate, double cgst, double sgst, double igst, double admissionFee, double totalValue) {
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

	public void setAmountPaid(long amountPaid) {
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

	public void setAmountActuallySettled(long amountActuallySettled) {
		this.amountActuallySettled = amountActuallySettled;
	}

	public double getExcess() {
		return excess;
	}

	public void setExcess(long excess) {
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

	public void setCgst(long cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(long sgst) {
		this.sgst = sgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(long igst) {
		this.igst = igst;
	}

	public double getAdmissionFee() {
		return admissionFee;
	}

	public void setAdmissionFee(long admissionFee) {
		this.admissionFee = admissionFee;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(long totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
