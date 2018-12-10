package com.biz.service;

import java.util.ArrayList;
import java.util.List;

import com.biz.inout.vo.IoComeVO;

public class IoComeService {

	List<IoComeVO> ioList;

	public IoComeService() {
		ioList = new ArrayList();
	}

	public void inOutInsert(IoComeVO vo) {
		// 단가 * 수량
		int intTotal = vo.getIntDan() * vo.getIntSu();
		vo.setIntTotal(intTotal);

		this.ioList.add(vo);
	}

	public void ioListPrint() {

		int intSize = ioList.size();

		System.out.println("매입리스트");
		System.out.println("====================================================");
		System.out.print("거래일자\t구분\t품목\t단가\t수량\t합계\n");
		System.out.println("----------------------------------------------------");
		for (int i = 0; i < intSize; i++) {
			if (ioList.get(i).getStrInout().equals("매입")) {
				System.out.print(ioList.get(i).getStrDate() + "\t" + ioList.get(i).getStrInout() + "\t"
						+ ioList.get(i).getStrPum() + "\t" + ioList.get(i).getIntSu() + "\t" + ioList.get(i).getIntDan()
						+ "\t" + ioList.get(i).getIntTotal() + "\n");
			}
		}
		System.out.println();

		System.out.println("매출리스트");
		System.out.println("====================================================");
		System.out.print("거래일자\t구분\t품목\t단가\t수량\t합계\n");
		System.out.println("----------------------------------------------------");
		for (int i = 0; i < intSize; i++) {
			if (ioList.get(i).getStrInout().equals("매출")) {
				System.out.print(ioList.get(i).getStrDate() + "\t" + ioList.get(i).getStrInout() + "\t"
						+ ioList.get(i).getStrPum() + "\t" + ioList.get(i).getIntSu() + "\t" + ioList.get(i).getIntDan()
						+ "\t" + ioList.get(i).getIntTotal() + "\n");
			}
		}
		System.out.println();

	}
	
	public void viewInOutTotal() {
		int intSize = ioList.size();
		int intInS = 0;
		int intOuS = 0;
		for(int i = 0 ; i < intSize; i++) {
			if(ioList.get(i).getStrInout().equals("매입")) {
				intInS += ioList.get(i).getIntTotal();
			}
		}
		for(int i = 0 ; i < intSize; i++) {
			if(ioList.get(i).getStrInout().equals("매출")) {
				intOuS += ioList.get(i).getIntTotal();
			}
		}
		System.out.println("====================================================");
		System.out.println("총 매입 합계 : " + intInS);
		System.out.println("총 매출 합계 : " + intOuS);
		System.out.println("이익금 : " + (intOuS - intInS));
		System.out.println("====================================================");
		
	}
}
