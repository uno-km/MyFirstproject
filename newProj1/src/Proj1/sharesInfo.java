package Proj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class sharesInfo extends Source {
	String maechulprint[] = new String[10];
	String youngupprint[] = new String[10];
	String dangiprint[] = new String[10];
	String youngupPerprint[] = new String[10];
	String soonprint[] = new String[10];
	String jibaeprint[] = new String[10];
	String buchaeprint[] = new String[10];
	String dangjwaprint[] = new String[10];
	String yuboprint[] = new String[10];
	String epsprint[] = new String[10];
	String perprint[] = new String[10];
	String bpsprint[] = new String[10];
	String pbrprint[] = new String[10];
	String divwonprint[] = new String[10];
	String divperprint[] = new String[10];
	String code = null;

	sharesInfo() {

	}

	sharesInfo(String name) throws IOException {
		sharesDAO dao = new sharesDAO();
		shareslist = dao.select_shares_info(name);
		for (int i = 0; i < shareslist.size(); i++) {
			sharesVo data = (sharesVo) shareslist.get(i);
			code = data.getCode();
		}
		URL url = new URL("https://finance.naver.com/item/main.nhn?code=" + code);
		URLConnection urlConn = url.openConnection();
		URLConnection urlConn2 = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		InputStreamReader inStream2 = new InputStreamReader(urlConn2.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		BufferedReader buff2 = new BufferedReader(inStream2);
		String line = buff.readLine();
		String line2 = buff2.readLine();
		int cnt = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int cnt5 = 0;
		int cnt6 = 0;
		int cnt7 = 0;
		int cnt8 = 0;
		int cnt9 = 0;
		int cnt10 = 0;
		int cnt11 = 0;
		int cnt12 = 0;
		int cnt13 = 0;
		int cnt14 = 0;
		int cnt15 = 0;
		int cnt16 = 0;
		int j = 0;
		String ful[] = new String[10000];
		while (line != null) {

			if (line.contains(">매출액<")) {// maechul
				cnt1 = cnt;
			}
			if (line.contains(">영업이익<")) {// youngwon
				cnt2 = cnt;
			}
			if (line.contains(">당기순이익<")) {// danggi
				cnt3 = cnt;
			}
			if (line.contains(">영업이익률<")) {// youngper
				cnt4 = cnt;
			}
			if (line.contains(">순이익률<")) {// soon
				cnt5 = cnt;
			}
			if (line.contains("<strong>ROE(지배주주)<")) { /// jibae
				cnt6 = cnt;
			}
			if (line.contains(">부채비율<")) {// buchae
				cnt7 = cnt;
			}
			if (line.contains(">당좌비율<")) {// dangjwa
				cnt8 = cnt;
			}
			if (line.contains(">유보율<")) {// yubo
				cnt9 = cnt;
			}
			if (line.contains(">EPS(원)<")) {// eps
				cnt10 = cnt;
			}
			if (line.contains(">PER(배)<")) {// per
				cnt11 = cnt;
			}
			if (line.contains(">BPS(원)<")) {// bps
				cnt12 = cnt;
			}
			if (line.contains("<strong>PBR(배)<")) {// pbr
				cnt13 = cnt;
			}
			if (line.contains("주당배당금")) {// divwon
				cnt14 = cnt;
			}
			if (line.contains("시가배당률")) {// divper
				cnt15 = cnt;
			}
			if (line.contains("배당성향")) {// divchar
				cnt16 = cnt;
			}
			cnt++;
			line = buff.readLine();
		}
		for (int i = 0; i < cnt; i++) {
			ful[i] = line2;
			line2 = buff2.readLine();
		}
		//// 매출액
		String maechul = "";
		for (int i = cnt1; i < cnt2; i++) {
			if (ful[i].length() > 1) {
				maechul += ful[i];
			}
		}
		String maechulrr[] = maechul.split("	");
		j = 0;
		for (int i = 0; i < maechulrr.length; i++) {
			if (maechulrr[i].contains(";")) {
				maechulprint[j] = "N/A";
				j++;
			} else if (maechulrr[i].length() > 0 && !maechulrr[i].contains("em") && !maechulrr[i].contains("td")
					&& !maechulrr[i].contains("<")) {
				maechulprint[j] = maechulrr[i];
				j++;
			}
		}
		/// 영업이익
		String youngup = "";
		for (int i = cnt2; i < cnt3; i++) {
			if (ful[i].length() > 1) {
				youngup += ful[i];
			}
		}
		String younguprr[] = youngup.split("	");
		j = 0;
		for (int i = 0; i < younguprr.length; i++) {
			if (younguprr[i].contains(";")) {
				youngupprint[j] = "N/A";
				j++;
			} else if (younguprr[i].length() > 0 && !younguprr[i].contains("em") && !younguprr[i].contains("td")
					&& !younguprr[i].contains("<")) {
				youngupprint[j] = younguprr[i];
				j++;
			}
		}
		// 당기순이익
		String dangi = "";
		for (int i = cnt3; i < cnt4; i++) {
			if (ful[i].length() > 1) {
				dangi += ful[i];
			}
		}
		String dangirr[] = dangi.split("	");
		j = 0;
		for (int i = 0; i < dangirr.length; i++) {
			if (dangirr[i].contains(";")) {
				dangiprint[j] = "N/A";
				j++;
			} else if (dangirr[i].length() > 0 && !dangirr[i].contains("em") && !dangirr[i].contains("td")
					&& !dangirr[i].contains("<")) {
				dangiprint[j] = dangirr[i];
				j++;
			}
		}
		// 영업퍼센트
		String youngupPer = "";
		for (int i = cnt4; i < cnt5; i++) {
			if (ful[i].length() > 1) {
				youngupPer += ful[i];
			}
		}
		String youngupPerrr[] = youngupPer.split("	");
		j = 0;
		for (int i = 0; i < youngupPerrr.length; i++) {
			if (youngupPerrr[i].contains(";")) {
				youngupPerprint[j] = "N/A";
				j++;
			} else if (youngupPerrr[i].length() > 0 && !youngupPerrr[i].contains("em")
					&& !youngupPerrr[i].contains("td") && !youngupPerrr[i].contains("<")) {
				youngupPerprint[j] = youngupPerrr[i];
				j++;
			}
		}
		// 순이익
		String soon = "";
		for (int i = cnt5; i < cnt6; i++) {
			if (ful[i].length() > 1) {
				soon += ful[i];
			}
		}
		String soonrr[] = soon.split("	");
		j = 0;
		for (int i = 0; i < soonrr.length; i++) {
			if (soonrr[i].contains(";")) {
				soonprint[j] = "N/A";
				j++;
			} else if (soonrr[i].length() > 0 && !soonrr[i].contains("em") && !soonrr[i].contains("td")
					&& !soonrr[i].contains("<")) {
				soonprint[j] = soonrr[i];
				j++;
			}
		}
		// 지배ROE
		String jibae = "";
		for (int i = cnt6; i < cnt7; i++) {
			if (ful[i].length() > 1) {
				jibae += ful[i];
			}
		}
		String jibaerr[] = jibae.split("	");
		j = 0;
		for (int i = 0; i < jibaerr.length; i++) {
			if (jibaerr[i].contains(";")) {
				jibaeprint[j] = "N/A";
				j++;
			} else if (jibaerr[i].length() > 0 && !jibaerr[i].contains("em") && !jibaerr[i].contains("td")
					&& !jibaerr[i].contains("<")) {
				jibaeprint[j] = jibaerr[i];
				j++;
			}
		}
		// 부채
		String buchae = "";
		for (int i = cnt7; i < cnt8; i++) {
			if (ful[i].length() > 1) {
				buchae += ful[i];
			}
		}
		String buchaerr[] = buchae.split("	");
		j = 0;
		for (int i = 0; i < buchaerr.length; i++) {
			if (buchaerr[i].contains(";")) {
				buchaeprint[j] = "N/A";
				j++;
			} else if (buchaerr[i].length() > 0 && !buchaerr[i].contains("em") && !buchaerr[i].contains("td")
					&& !buchaerr[i].contains("<")) {
				buchaeprint[j] = buchaerr[i];
				j++;
			}

		}
		// 당좌
		String dangjwa = "";
		for (int i = cnt8; i < cnt9; i++) {
			if (ful[i].length() > 1) {
				dangjwa += ful[i];
			}
		}
		String dangjwarr[] = dangjwa.split("	");
		j = 0;
		for (int i = 0; i < dangjwarr.length; i++) {
			if (dangjwarr[i].contains(";")) {
				dangjwaprint[j] = "N/A";
				j++;
			} else if (dangjwarr[i].length() > 0 && !dangjwarr[i].contains("em") && !dangjwarr[i].contains("td")
					&& !dangjwarr[i].contains("<")) {
				dangjwaprint[j] = dangjwarr[i];
				j++;
			}
		}
		// 유보율
		String yubo = "";
		for (int i = cnt9; i < cnt10; i++) {
			if (ful[i].length() > 1) {
				yubo += ful[i];
			}
		}
		String yuborr[] = yubo.split("	");
		j = 0;
		for (int i = 0; i < yuborr.length; i++) {
			if (yuborr[i].contains(";")) {
				yuboprint[j] = "N/A";
				j++;
			} else if (yuborr[i].length() > 0 && !yuborr[i].contains("em") && !yuborr[i].contains("td")
					&& !yuborr[i].contains("<")) {
				yuboprint[j] = yuborr[i];
				j++;
			}
		}
		// eps
		String eps = "";
		for (int i = cnt10; i < cnt11; i++) {
			if (ful[i].length() > 1) {
				eps += ful[i];
			}
		}
		String epsrr[] = eps.split("	");
		j = 0;
		for (int i = 0; i < epsrr.length; i++) {
			if (epsrr[i].contains(";")) {
				epsprint[j] = "N/A";
				j++;
			} else if (epsrr[i].length() > 0 && !epsrr[i].contains("em") && !epsrr[i].contains("td")
					&& !epsrr[i].contains("<")) {
				epsprint[j] = epsrr[i];
				j++;
			}
		}
		// per
		String per = "";
		for (int i = cnt11; i < cnt12; i++) {
			if (ful[i].length() > 1) {
				per += ful[i];
			}
		}
		String perrr[] = per.split("	");
		j = 0;
		for (int i = 0; i < perrr.length; i++) {
			if (perrr[i].contains(";")) {
				perprint[j] = "N/A";
				j++;
			} else if (perrr[i].length() > 0 && !perrr[i].contains("em") && !perrr[i].contains("td")
					&& !perrr[i].contains("<")) {
				perprint[j] = perrr[i];
				j++;
			}
		}
		// bps
		String bps = "";
		for (int i = cnt12; i < cnt13; i++) {
			if (ful[i].length() > 1) {
				bps += ful[i];
			}
		}
		String bpsrr[] = bps.split("	");
		j = 0;
		for (int i = 0; i < bpsrr.length; i++) {
			if (bpsrr[i].contains(";")) {
				j++;
			} else if (bpsrr[i].length() > 0 && !bpsrr[i].contains("em") && !bpsrr[i].contains("td")
					&& !bpsrr[i].contains("<")) {
				bpsprint[j] = bpsrr[i];
				j++;
			}
		}
		// pbr
		String pbr = "";
		for (int i = cnt13; i < cnt14; i++) {
			if (ful[i].length() > 1) {
				pbr += ful[i];
			}
		}
		String pbrrr[] = pbr.split("	");
		j = 0;
		for (int i = 0; i < pbrrr.length; i++) {
			if (pbrrr[i].contains(";")) {
				pbrprint[j] = "N/A";
				j++;
			} else if (pbrrr[i].length() > 0 && !pbrrr[i].contains("em") && !pbrrr[i].contains("td")
					&& !pbrrr[i].contains("<")) {
				pbrprint[j] = pbrrr[i];
				j++;
			}
		}
		// 배당원
		String divwon = "";
		for (int i = cnt14; i < cnt15; i++) {
			if (ful[i].length() > 1) {
				divwon += ful[i];
			}
		}
		String divwonrr[] = divwon.split("	");
		j = 0;
		for (int i = 0; i < divwonrr.length; i++) {
			if (divwonrr[i].contains(";") || divwonrr[i].contains("<td class=\"no")) {
				divwonprint[j] = "N/A";
				j++;
			} else if (divwonrr[i].length() > 0 && !divwonrr[i].contains("em") && !divwonrr[i].contains("td")
					&& !divwonrr[i].contains("<")) {
				divwonprint[j] = divwonrr[i];
				j++;
			}
		}
		// 배당퍼센트
		String divper = "";
		for (int i = cnt15; i < cnt16; i++) {
			if (ful[i].length() > 1) {
				divper += ful[i];
			}
		}
		String divperrr[] = divper.split("	");
		j = 0;
		for (int i = 0; i < divperrr.length; i++) {
			if (divperrr[i].contains(";") || divperrr[i].contains("<td class=\"no")) {
				divperprint[j] = "N/A";
				j++;
			} else if (divperrr[i].length() > 0 && !divperrr[i].contains("em") && !divperrr[i].contains("td")
					&& !divperrr[i].contains("<")) {
				divperprint[j] = divperrr[i];
				j++;
			}
		}
	}
}
