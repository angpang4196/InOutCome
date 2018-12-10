package com.biz.inout.exec;

import java.util.Scanner;

import com.biz.inout.vo.IoComeVO;
import com.biz.service.IoComeService;

public class IoComeExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IoComeService is = new IoComeService();

		while (true) {
			IoComeVO vo = ioInsert();
			// vo에 담기는 값은 완성된 vo이거나 null
			/*if (vo.getStrDate().equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}

			// 변환 과정에서 오류가 있었으면
			if (vo.getIntDan() < 0 || vo.getIntSu() < 0) {
				System.out.println("단가나 수량 입력 오류");
				continue;
			}*/
			is.inOutInsert(vo);
		}
	
//		vo.setStrDate("2018-12-07");
//		vo.setStrInout("매입");
//		vo.setStrPum("새콤달콤");
//		vo.setIntSu(3);
//		vo.setIntDan(2000);
//
//		is.inOutInsert(vo);

	}

	public static IoComeVO ioInsert() {

		IoComeVO vo = new IoComeVO();

		Scanner scan = new Scanner(System.in);
		System.out.println("===================================");
		System.out.println("매입 매출 등록");
		System.out.println("-----------------------------------");
		System.out.print("거래일(-1:종료) >>");
		String strDate = scan.nextLine();
		if (strDate.equals("-1")) { // 종료 코드
			return null;
		}
		System.out.print("거래방법(매입/매출) >>");
		String strInOut = scan.nextLine();

		System.out.print("품목(상품명) >>");
		String strPum = scan.nextLine();

		try {
			System.out.print("단가 >>");
			String strDan = scan.nextLine();
			int intDan = Integer.valueOf(strDan.trim());

			System.out.print("수량 >>");
			String strSu = scan.nextLine();
			int intSu = Integer.valueOf(strSu.trim());

			vo.setStrDate(strDate);
			vo.setStrInout(strInOut);
			vo.setStrPum(strPum);
			vo.setIntSu(intSu);
			vo.setIntDan(intDan);

		} catch (Exception e) {
			System.out.println("입력이 잘못되었습니다.");
			return null;
		}

		return vo;
	}

}