package Proj1;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.CheckboxMenuItem;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.util.ArrayList;

public class Source {

	///// SHARING Sources
	ArrayList<MemberVo> list, findIdenty;
	ArrayList<sharesVo> shareslist, select_proverb, show_trade_val, Load_user_interest_list;
	ArrayList<Logininfo> Loginlist, Search_login_list;
	ArrayList<MemberVo> findPassword;
	sharesDAO sharesDao;
	MemberDAO dao;
	/////////////////////// StartFrame Sources

	//// ÆùÆ®
	Font IfontIssue, IfontIssueChar;
	Font marketPanelFont1, marketPanelFont2, marketPanelFont3;
	Font InterNamefont, InterPricefont, GoalFont1, GoalFont2, GoalFont3;
	Font GoalFont4, MiniFont;
	////
	TextField tfId, tfPwd, tfMsg;
	TextField tfregid, tfregpw, tfregm, tfregemail;
	TextField tfIdemail, tfIdid, tfIdm, tfPwdid, tfPwdemail, tfPwdm;
	TextField DuptfLoginId, DuptfLoginTime;
	Frame Ffind;
	Button login, reg, add, back, lok, regbDC, find;
	Button findId, findPwd, findBid, findBpwd;
	Button findBidBack, findBpwdBack, Eback, Econfirm;
	Button DupBLogoff, DupDBconfirm;
	Label lid, lpw;
	Label lregid, lregpw, tflok, lque, DupLloginlist1, DupDLconfirm;
	Label DupLloginlist2, DupLId, DupLTime;
	Dialog regD, lokD, E, Dduplicate, DDok;
	Panel Plang, PfindId, PfindPwd;
	Label llang, findLidEmail, findLidId, findLpwdId, findLpwdEmail;
	Label reglid, reglpw, reglemail, El1, El2, DDLok;

	Frame Lbody;
	////////////////////////// bodyFrame Sources
	int s1 = 0, s2 = 0, s3 = 0, s4 = 0;
	int updowndelete = 0;

	Frame Fchart, Fminiwindow, Body, Fgoal;
	Frame Fgive, Fother;
	Frame Fmodify, Fwith;
	Frame Fissue;
	PopupMenu pMenuBody, pMenuFin, pMenuinter, pMenuMarket;

	Dialog Dexit, Mdpwd, Wdpwd, Mdok, WsDok, Gok, Iadd, DInterWarning;
	Dialog GoalDok, LogoutDyesorno, LogoutDok, DduplicateLogoff;
	Button Dbexit, CbSearch, Mbpwd, WsDbok;
	Button modbmod, modbback, mobwith, mbok;
	Button Wbsubmit, Fbchart, Fbinterest, Fbsearch;
	Button Gbsubmit, Gbok, FbIssue, FbaddInter, Iaddbok;
	Button DBwarningOk, IBrefresh, IbMinus[] = new Button[10];
	Button GoalDBok, GoalBsave, GoalBback, LogoutByes, LogoutBno;
	Button LogoutBok, DuplicateBok, MiniBF5;
	Label Dexitl, Dlogtime, MdLpw, Mlok, modlid, modlpw, WsDlok;
	Label modlemail, Wlreason, Flprice, Fly, Flyp;
	Label Lmarket, Glreason, Glok;
	Label Istop, Iissue, Ilow, Ireport, Imid, Ihigh, Idanger;
	Label IstopChar, IissueChar, IlowChar, IreportChar, ImidChar, IhighChar, IdangerChar;
	Label InterName[] = new Label[10], InterNowprice[] = new Label[10];
	Label Interupdown[] = new Label[10], Interdiffprice[] = new Label[10];
	Label IaddLok, DLwarningOk;
	Label LsearchSetting, GoalLupper, GoalLdowner, GoalLclicked;
	Label GoalLinterestList[] = new Label[10], GoalLdelete;
	Label GoalDLok, GoalLyourinterst, GoalLclcikednowprice, GoalLname;
	Label GoalLprice, GoalLnowprice[] = new Label[10];
	Label InterestGoalstate[] = new Label[10], LogoutLyesorno, LogoutLok;
	Label MiniName[] = new Label[10], MiniNowprice[] = new Label[10];
	Label DuplicateLok;
	Checkbox GoalCBupper, GoalCBdowner, GoalCBdelete;
	CheckboxGroup GoalGroup;

	TextField Ctfsearch, Mtfpwd, Wtfreason, Ftfsearch2;
	TextField modtfid, modtfpw, modtfemail, Ftfprice;
	TextField Ftfy, Ftfyp, Ftfp, Gtfreason, Goaltfupper;
	TextField Goaltfdowner, Fthmarket, Fthsector;
	Panel Pfin, Pinterest, Pmarket;
	Menu mView, mUser, mHelp;
	MenuBar menuBar;
	MenuItem mIchart, mIshort, mIdart, mIdang, mIdicus;
	MenuItem mPgoal, mPmodify;
	MenuItem mHgive, mHother, mHlogout;
	MenuItem pmF5, pmShort, pmNaver, pmDart, pmGoal;
	CheckboxMenuItem CBMfin, CBMinterest, CBDARK;

	Checkbox ch1, ch2, ch3, ch4, ch5;
	Checkbox Gch1, Gch2, Gch3, Gch4, Gch5;
	///////////// On time Source
	Label lbl1, lbl2, lbl3, Minitime;
	Button Bre;
	//////////////
	Font Fonttable1, Fonttable2, Fonttable3, Fonttable4;
	Panel Pupper, Pleft, Pinfo1, Pinfo2;
	Label Lmaechul, Lyounup, Ldangi, Lyoungupper, Lsoon, Ljibae;
	Label Lbuchae, Ldangjwa, Lyubo, Leps, Lper, Lbps, Lpbr;
	Label Ldivwon, Ldivper, Lyear, Lque, L1812, L1912, L2012, L202112;
	Label Lq2003, Lq2006, Lq2009, Lq2012, Lq2103, Lq2106;
	Label[] Lmaechulnum = new Label[10];
	Label[] Lyounupnum = new Label[10];
	Label[] Ldanginum = new Label[10];
	Label[] Lyounguppernum = new Label[10];
	Label[] Lsoonnum = new Label[10];
	Label[] Ljibaenum = new Label[10];

	Label[] Lbuchaenum = new Label[10];
	Label[] Ldangjwanum = new Label[10];
	Label[] Lyubonum = new Label[10];
	Label[] Lepsnum = new Label[10];
	Label[] Lpernum = new Label[10];
	Label[] Lbpsnum = new Label[10];
	Label[] Lpbrnum = new Label[10];
	Label[] Ldivwonnum = new Label[10];
	Label[] Ldivpernum = new Label[10];
}
