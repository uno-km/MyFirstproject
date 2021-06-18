package Proj1;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class bodyFrame extends Source implements ActionListener, Runnable {
	int darkmode = 0;

	bodyFrame(String id) {
		sharesDao = new sharesDAO();

		dao = new MemberDAO();
		list = dao.list(id);
		MemberVo data = (MemberVo) list.get(0);
		Date today = new Date();
		Body = new Frame(id + "��, ȯ���մϴ�.      Login time : " + today);
		String nowEmail = data.getEmail();
		Body.setSize(1300, 800);
		Body.setLayout(null);
		Body.setVisible(true);
		Body.setLocationRelativeTo(null);
		Body.addWindowListener(new programExit());
		LsearchSetting = new Label("", Label.LEFT);
		menuBar = new MenuBar();
		mView = new Menu("Info");
		CBMfin = new CheckboxMenuItem("�繫����ǥ");
		CBMfin.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					Pupper.setVisible(true);
					Pleft.setVisible(true);
					Pinfo1.setVisible(true);
				} else {
					Pupper.setVisible(false);
					Pleft.setVisible(false);
					Pinfo1.setVisible(false);
				}
			}
		});
		mIshort = new MenuItem("���ŵ� ��Ȳ ����", new MenuShortcut(KeyEvent.VK_S));
		mIdart = new MenuItem("��Ʈ(DART) ����Ȯ��", new MenuShortcut(KeyEvent.VK_D));
		mIdicus = new MenuItem("������й�(NAVER)", new MenuShortcut(KeyEvent.VK_N));
		mUser = new Menu("user");

		mPgoal = new MenuItem("��ǥ�� ����", new MenuShortcut(KeyEvent.VK_T));
		mPmodify = new MenuItem("ȸ������ ����");
		mHelp = new Menu("Help");
		mHgive = new MenuItem("���α׷� ��������");
//		mHother = new MenuItem("others..");
		mHlogout = new MenuItem("�α׾ƿ�", new MenuShortcut(KeyEvent.VK_L));

		Dexit = new Dialog(Body, "����", true);
		Dexit.setSize(150, 105);
		Dexit.setLocationRelativeTo(Dbexit);
		Dexit.setLayout(null);
		Dexit.addWindowListener(new exitExit());
		Dexit.setAlwaysOnTop(true);

		Dexitl = new Label("�����Ͻðڽ��ϱ�? ?", Label.CENTER);
		Dexitl.setBounds(0, 40, 150, 20);

		Dbexit = new Button("����");
		Dbexit.setLocation(25, 65);
		Dbexit.setSize(100, 30);
		Dbexit.addActionListener(new programExit());
		Dbexit.addKeyListener(new programExit());

		// �α׾ƿ� ���
		mHlogout.addActionListener(new logoutEvent());
		LogoutDyesorno = new Dialog(Body, "�α׾ƿ� Ȯ��", true);
		LogoutDyesorno.setSize(220, 105);
		LogoutDyesorno.setLocationRelativeTo(null);
		LogoutDyesorno.setLayout(null);
		LogoutDyesorno.addWindowListener(new logoutEvent());
		LogoutDyesorno.addKeyListener(new logoutEvent());

		LogoutByes = new Button("��");
		LogoutByes.setSize(70, 30);
		LogoutByes.setLocation(30, 60);
		LogoutByes.addActionListener(new logoutEvent());
		LogoutByes.addKeyListener(new logoutEvent());
		LogoutBno = new Button("�ƴϿ�");
		LogoutBno.setSize(70, 30);
		LogoutBno.setLocation(120, 60);
		LogoutBno.addActionListener(new logoutEvent());

		LogoutLyesorno = new Label("������ �α׾ƿ� �Ͻðڽ��ϱ�?", Label.CENTER);
		LogoutLyesorno.setBounds(0, 35, 220, 20);

		LogoutDyesorno.add(LogoutByes);
		LogoutDyesorno.add(LogoutBno);
		LogoutDyesorno.add(LogoutLyesorno);

		LogoutDok = new Dialog(Body, "�α׾ƿ� ����", true);
		LogoutDok.setSize(150, 105);
		LogoutDok.setLocationRelativeTo(null);
		LogoutDok.setLayout(null);
		LogoutDok.addWindowListener(new logoutEvent2());
		LogoutDok.addKeyListener(new logoutEvent2());

		LogoutLok = new Label("�α׾ƿ� �Ϸ�.", Label.CENTER);
		LogoutLok.setBounds(0, 35, 150, 20);

		LogoutBok = new Button("���α׷� �����");
		LogoutBok.setSize(100, 30);
		LogoutBok.setLocation(25, 60);
		LogoutBok.addActionListener(new logoutEvent2());
		LogoutBok.addKeyListener(new logoutEvent2());

		LogoutDok.add(LogoutLok);
		LogoutDok.add(LogoutBok);

		//

		Iadd = new Dialog(Body, "���������߰�", true);
		Iadd.setSize(150, 105);
		Iadd.setLocationRelativeTo(Dbexit);
		Iadd.setLayout(null);
		Iadd.addWindowListener(new exitExit());
		Iadd.setAlwaysOnTop(true);

		IaddLok = new Label("�������� �߰��Ϸ�.", Label.CENTER);
		IaddLok.setBounds(0, 40, 150, 20);

		Iaddbok = new Button("Ȯ��");
		Iaddbok.setLocation(25, 65);
		Iaddbok.setSize(100, 30);
		Iaddbok.addActionListener(new AddEvent());
		Iaddbok.addKeyListener(new AddEvent());

		Dexit.add(Dexitl);
		Dexit.add(Dbexit);
		Dexit.setVisible(false);
		Iadd.add(IaddLok);
		Iadd.add(Iaddbok);
		Iadd.setVisible(false);

		menuBar.add(mView);
		menuBar.add(mUser);
		menuBar.add(mHelp);

//		mView.add(mIchart);
		mView.add(CBMfin);
		mView.add(mIshort);
		mView.addSeparator();
		mView.add(mIdart);
		mView.add(mIdicus);

		Pfin = new Panel();
		Pfin.setLayout(null);
		Pfin.setSize(1000, 680);
		Pfin.setLocation(20, 55);
		Pfin.setVisible(true);

		Fbsearch = new Button("�˻�");
		Fbsearch.setSize(40, 25);
		Fbsearch.setLocation(210, 5);
		Fbsearch.addActionListener(new bodyFrameEvent());

		FbIssue = new Button("�ŷ�����");
		FbIssue.setSize(70, 25);
		FbIssue.setLocation(265, 5);
		FbIssue.addActionListener(new bodyFrameEvent());

		FbaddInter = new Button("���������߰�");
		FbaddInter.setSize(85, 25);
		FbaddInter.setLocation(340, 5);
		FbaddInter.addActionListener(new AddEvent());

		Ftfsearch2 = new TextField("");
		Ftfsearch2.setSize(200, 25);
		Ftfsearch2.setLocation(5, 5);
		Ftfsearch2.addActionListener(new bodyFrameEvent());

		Ftfprice = new TextField("");
		Ftfprice.setSize(150, 25);
		Ftfprice.setEditable(false);
		Ftfprice.setLocation(55, 35);

		Ftfy = new TextField("");
		Ftfy.setSize(40, 25);
		Ftfy.setEditable(false);
		Ftfy.setLocation(265, 35);

		Ftfyp = new TextField("");
		Ftfyp.setSize(60, 25);
		Ftfyp.setEditable(false);
		Ftfyp.setLocation(310, 35);

		Ftfp = new TextField("");
		Ftfp.setSize(50, 25);
		Ftfp.setEditable(false);
		Ftfp.setLocation(375, 35);
		Flprice = new Label("���簡", Label.CENTER);
		Flprice.setSize(50, 25);
		Flprice.setLocation(5, 35);
		Fly = new Label("���ϴ��", Label.CENTER);
		Fly.setSize(50, 25);
		Fly.setLocation(210, 35);

		Fthmarket = new TextField("");
		Fthmarket.setSize(80, 25);
		Fthmarket.setEditable(false);
		Fthmarket.setLocation(440, 35);

		Fissue = new Frame("�ŷ�����");
		Fissue.setLayout(null);
		Fissue.setLocationRelativeTo(null);
		Fissue.setVisible(false);
		Fissue.setSize(580, 110);
		Fissue.setAlwaysOnTop(true);

		IfontIssue = new Font("���", Font.BOLD, 14);
		IfontIssueChar = new Font("���", Font.BOLD, 16);
		Istop = new Label("�ŷ�����", Label.CENTER);
		Istop.setBounds(15, 30, 60, 30);
		Istop.setForeground(Color.red);
		Istop.setFont(IfontIssue);
		Iissue = new Label("��������", Label.CENTER);
		Iissue.setBounds(85, 30, 60, 30);
		Iissue.setFont(IfontIssue);
		Ilow = new Label("��������ȯ��", Label.CENTER);
		Ilow.setBounds(155, 30, 100, 30);
		Ilow.setFont(IfontIssue);
		Ireport = new Label("�Ҽ��ǰ���", Label.CENTER);
		Ireport.setBounds(265, 30, 80, 30);
		Ireport.setFont(IfontIssue);
		Imid = new Label("��������", Label.CENTER);
		Imid.setBounds(355, 30, 60, 30);
		Imid.setFont(IfontIssue);
		Ihigh = new Label("���ڰ��", Label.CENTER);
		Ihigh.setBounds(425, 30, 60, 30);
		Ihigh.setFont(IfontIssue);
		Idanger = new Label("��������", Label.CENTER);
		Idanger.setBounds(495, 30, 60, 30);
		Idanger.setForeground(Color.red);
		Idanger.setFont(IfontIssue);

		IstopChar = new Label("", Label.CENTER);
		IstopChar.setBounds(15, 70, 60, 30);
		IstopChar.setForeground(Color.red);
		IstopChar.setFont(IfontIssueChar);
		IissueChar = new Label("", Label.CENTER);
		IissueChar.setBounds(85, 70, 60, 30);
		IissueChar.setFont(IfontIssueChar);
		IlowChar = new Label("", Label.CENTER);
		IlowChar.setBounds(155, 70, 100, 30);
		IlowChar.setFont(IfontIssueChar);
		IreportChar = new Label("", Label.CENTER);
		IreportChar.setBounds(265, 70, 80, 30);
		IreportChar.setFont(IfontIssueChar);
		ImidChar = new Label("", Label.CENTER);
		ImidChar.setBounds(355, 70, 60, 30);
		ImidChar.setFont(IfontIssueChar);
		IhighChar = new Label("", Label.CENTER);
		IhighChar.setBounds(425, 70, 60, 30);
		IhighChar.setFont(IfontIssueChar);
		IdangerChar = new Label("", Label.CENTER);
		IdangerChar.setBounds(495, 70, 60, 30);
		IdangerChar.setForeground(Color.red);
		IdangerChar.setFont(IfontIssueChar);
		Fissue.addWindowListener(new issueExit());

		Pfin.add(Ftfsearch2);
		Pfin.add(Fbsearch);
		Pfin.add(Flprice);
		Pfin.add(Fly);
		Pfin.add(Ftfprice);
		Pfin.add(Ftfy);
		Pfin.add(Ftfyp);
		Pfin.add(Ftfp);
		Pfin.add(FbIssue);
		Pfin.add(FbaddInter);
		Pfin.add(Fthmarket);
		Fissue.add(Istop);
		Fissue.add(Ireport);
		Fissue.add(Idanger);
		Fissue.add(Iissue);
		Fissue.add(Imid);
		Fissue.add(Ilow);
		Fissue.add(Ihigh);
		Fissue.add(IstopChar);
		Fissue.add(IreportChar);
		Fissue.add(IdangerChar);
		Fissue.add(IissueChar);
		Fissue.add(ImidChar);
		Fissue.add(IlowChar);
		Fissue.add(IhighChar);

		Pinterest = new Panel();
		Pinterest.setBackground(Color.orange);
		Pinterest.setSize(260, 680);
		Pinterest.setLocation(1025, 55);
		Pinterest.setVisible(false);
		Pinterest.setLayout(null);

		mIshort.addActionListener(new bodyFrameEvent());
		Fminiwindow = new Frame("�ּ�ȭ���");
		Fminiwindow.setSize(180, 300);
		Fminiwindow.setLayout(null);
		Fminiwindow.setAlwaysOnTop(true);
		Fminiwindow.setLocation(1350, 520);
		Fminiwindow.addWindowListener(new miniwindowEvent());
		Fminiwindow.addMouseListener(new miniwindowEvent());
		Fminiwindow.addMouseListener(new miniwindowEvent());
		Fminiwindow.addMouseWheelListener(new miniwindowEvent());
		////////////////////
		MiniFont = new Font("�����ڵ����", Font.BOLD, 13);
		for (int i = 0; i < 10; i++) {
			MiniName[i] = new Label("", Label.LEFT);
			MiniName[i].setBounds(10, 10 + i * 25, 100, 25);
			MiniName[i].setFont(MiniFont);
			MiniName[i].addMouseListener(new miniwindowEvent());
			MiniName[i].addMouseWheelListener(new miniwindowEvent());
			MiniNowprice[i] = new Label("", Label.RIGHT);
			MiniNowprice[i].setBounds(110, 10 + i * 25, 60, 25);
			MiniNowprice[i].setFont(MiniFont);
			MiniNowprice[i].addMouseListener(new miniwindowEvent());
			MiniNowprice[i].addMouseWheelListener(new miniwindowEvent());
			Fminiwindow.add(MiniName[i]);
			Fminiwindow.add(MiniNowprice[i]);
		}
		Minitime = new Label("", Label.LEFT);
		Minitime.setBounds(10, 270, 180, 25);
		Minitime.setFont(MiniFont);
		Fminiwindow.add(Minitime);

		/////////////////////

		mIdicus.addActionListener(new bodyFrameEvent());
		mIdart.addActionListener(new bodyFrameEvent());

		mPgoal.addActionListener(new bodyFrameEvent());
		Fgoal = new Frame("��ǥ�� ����");
		Fgoal.setSize(600, 500);
		Fgoal.setLayout(null);
		Fgoal.setAlwaysOnTop(true);
		Fgoal.addWindowListener(new GoalEvent());
		Fgoal.setLocationRelativeTo(null);

		// ��ǥ������ ������//
		GoalFont2 = new Font("��������ڵ�", Font.PLAIN, 18);
		GoalFont1 = new Font("��������ڵ�", Font.BOLD, 23);
		GoalFont3 = new Font("��������ڵ�", Font.BOLD, 23);
		GoalFont4 = new Font("��������ڵ�", Font.BOLD, 20);
		GoalLyourinterst = new Label("�����Ͻ� ���� �̸��� Ŭ���ϼ���.", Label.CENTER);
		GoalLyourinterst.setBounds(20, 50, 370, 40);
		GoalLyourinterst.setFont(GoalFont1);
		GoalLclicked = new Label(" ", Label.CENTER);
		GoalLclicked.setBounds(400, 50, 180, 40);
		GoalLclicked.setFont(GoalFont1);
		GoalLclicked.setBackground(Color.gray);

		GoalLname = new Label("�����", Label.CENTER);
		GoalLname.setBounds(20, 90, 160, 30);
		GoalLname.setBackground(new Color(224, 224, 224));
		GoalLname.setFont(GoalFont4);
		GoalLprice = new Label("���簡", Label.CENTER);
		GoalLprice.setBounds(180, 90, 160, 30);
		GoalLprice.setBackground(new Color(224, 224, 224));
		GoalLprice.setFont(GoalFont4);

		Goaltfupper = new TextField();
		Goaltfupper.setSize(80, 30);
		Goaltfupper.setLocation(390, 130);
		Goaltfupper.setEditable(false);

		GoalLupper = new Label("�� �̻�.", Label.LEFT);
		GoalLupper.setBounds(475, 130, 70, 30);
		GoalLupper.setFont(GoalFont2);

		GoalGroup = new CheckboxGroup();
		GoalCBupper = new Checkbox("", GoalGroup, true);
		GoalCBupper.setLocation(370, 135);
		GoalCBupper.setSize(10, 10);
		GoalCBupper.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					Goaltfupper.setEditable(true);
					Goaltfdowner.setEditable(false);
					Goaltfdowner.setText("");
				} else {
					Goaltfupper.setEditable(false);
					Goaltfupper.setText("");
					Goaltfdowner.setEditable(true);
				}

			}
		});
		GoalLdowner = new Label("�� ����.", Label.LEFT);
		GoalLdowner.setBounds(475, 190, 70, 30);
		GoalLdowner.setFont(GoalFont2);

		Goaltfdowner = new TextField();
		Goaltfdowner.setSize(80, 30);
		Goaltfdowner.setLocation(390, 190);
		Goaltfdowner.setEditable(false);

		GoalCBdowner = new Checkbox("", GoalGroup, true);
		GoalCBdowner.setLocation(370, 195);
		GoalCBdowner.setSize(10, 10);
		GoalCBdowner.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					Goaltfupper.setEditable(false);
					Goaltfdowner.setEditable(true);
					Goaltfupper.setText("");
				} else {
					Goaltfdowner.setEditable(false);
					Goaltfupper.setEditable(true);
					Goaltfdowner.setText("");
				}
			}
		});
		GoalLdelete = new Label("��ǥ�� ����", Label.LEFT);
		GoalLdelete.setBounds(390, 250, 110, 30);
		GoalLdelete.setFont(GoalFont2);

		GoalCBdelete = new Checkbox("", GoalGroup, true);
		GoalCBdelete.setLocation(370, 255);
		GoalCBdelete.setSize(10, 10);
		GoalCBdelete.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					Goaltfupper.setEditable(false);
					Goaltfdowner.setEditable(false);
					Goaltfupper.setText("");
					Goaltfdowner.setText("");
				} else {

				}
			}
		});

		GoalDok = new Dialog(Fgoal, "��ǥ�� �����Ϸ�", true);
		GoalDok.setSize(200, 105);
		GoalDok.setLocationRelativeTo(Fgoal);
		GoalDok.setLayout(null);
		GoalDok.setVisible(false);
		GoalDok.addWindowListener(new GoalDialogExit());

		GoalDLok = new Label("��ǥ�� ������ �Ϸ�Ǿ����ϴ�.", Label.CENTER);
		GoalDLok.setBounds(0, 30, 200, 30);

		GoalDBok = new Button("Ȯ��");
		GoalDBok.setSize(100, 20);
		GoalDBok.setLocation(50, 70);
		GoalDBok.addActionListener(new GoalEvent());

		GoalDok.add(GoalDLok);
		GoalDok.add(GoalDBok);

		GoalBsave = new Button("�����ϱ�");
		GoalBsave.setSize(100, 40);
		GoalBsave.setLocation(400, 305);
		GoalBsave.addActionListener(new GoalEvent());
		GoalBback = new Button("���ư���");
		GoalBback.setSize(100, 40);
		GoalBback.setLocation(400, 350);
		GoalBback.addActionListener(new GoalEvent());

		for (int i = 0; i < 10; i++) {
			GoalLinterestList[i] = new Label("", Label.LEFT);
			GoalLinterestList[i].setBounds(30, 130 + 35 * i, 160, 30);
			GoalLinterestList[i].setFont(GoalFont2);
			GoalLnowprice[i] = new Label("", Label.CENTER);
			GoalLnowprice[i].setBounds(180, 130 + 35 * i, 160, 30);
			GoalLnowprice[i].setFont(GoalFont2);
			Fgoal.add(GoalLinterestList[i]);
			Fgoal.add(GoalLnowprice[i]);
		}

		Fgoal.add(GoalLyourinterst);
		Fgoal.add(GoalLclicked);
		Fgoal.add(GoalLupper);
		Fgoal.add(GoalLdowner);
		Fgoal.add(GoalCBupper);
		Fgoal.add(GoalCBdowner);
		Fgoal.add(Goaltfupper);
		Fgoal.add(Goaltfdowner);
		Fgoal.add(GoalLname);
		Fgoal.add(GoalLprice);
		Fgoal.add(GoalBsave);
		Fgoal.add(GoalBback);
		Fgoal.add(GoalLdelete);
		Fgoal.add(GoalCBdelete);
		GoalLinterestList[0].addMouseListener(new GoalListinterestListEvent1());
		GoalLinterestList[1].addMouseListener(new GoalListinterestListEvent2());
		GoalLinterestList[2].addMouseListener(new GoalListinterestListEvent3());
		GoalLinterestList[3].addMouseListener(new GoalListinterestListEvent4());
		GoalLinterestList[4].addMouseListener(new GoalListinterestListEvent5());
		GoalLinterestList[5].addMouseListener(new GoalListinterestListEvent6());
		GoalLinterestList[6].addMouseListener(new GoalListinterestListEvent7());
		GoalLinterestList[7].addMouseListener(new GoalListinterestListEvent8());
		GoalLinterestList[8].addMouseListener(new GoalListinterestListEvent9());
		GoalLinterestList[9].addMouseListener(new GoalListinterestListEvent10());
		////////////////////

		mPmodify.addActionListener(new modifyEvent());
		Fmodify = new Frame("ȸ����������");
		Fmodify.setSize(450, 250);
		Fmodify.setLayout(null);
		Fmodify.setLocationRelativeTo(null);
		Fmodify.setAlwaysOnTop(true);
		Fmodify.addWindowListener(new modifyEvent());

		Mdpwd = new Dialog(Body, "��й�ȣ Ȯ��", true);
		Mdpwd.setSize(300, 110);
		Mdpwd.setLocationRelativeTo(null);
		Mdpwd.setLayout(null);
		Mdpwd.addWindowListener(new MdpwdExit());
		MdLpw = new Label("��й�ȣ�� �Է����ּ���.", Label.CENTER);
		MdLpw.setBounds(5, 40, 200, 20);
		Mtfpwd = new TextField();
		Mtfpwd.setEchoChar('*');
		Mtfpwd.setSize(200, 30);
		Mtfpwd.setLocation(30, 60);
		Mdpwd.setAlwaysOnTop(true);

		Mbpwd = new Button("Ȯ��");
		Mbpwd.setSize(50, 30);
		Mbpwd.setLocation(235, 60);
		Mbpwd.addActionListener(new modifyEvent());
		Mtfpwd.addActionListener(new modifyEvent());

		Mdpwd.setVisible(false);

		modlid = new Label("I      D : ", Label.LEFT);
		modlid.setBounds(20, 70, 60, 20);
		modtfid = new TextField();
		modtfid.setSize(200, 30);
		modtfid.setLocation(100, 70);
		modtfid.setEditable(false);
		modtfid.setText(id);

		modlpw = new Label("Password : ", Label.LEFT);
		modlpw.setBounds(20, 110, 60, 20);
		modtfpw = new TextField();
		modtfpw.setEchoChar('*');
		modtfpw.setSize(200, 30);
		modtfpw.setLocation(100, 110);
		modtfpw.addActionListener(new modifyEvent());

		modlemail = new Label("E-mail : ", Label.LEFT);
		modlemail.setBounds(20, 150, 60, 20);
		modtfemail = new TextField();
		modtfemail.setSize(200, 30);
		modtfemail.setLocation(100, 150);
		modtfemail.setText(nowEmail);

		modbmod = new Button("�����ϱ�");
		modbmod.setSize(105, 35);
		modbmod.setLocation(320, 65);
		modbmod.addActionListener(new modifyEvent());

		mobwith = new Button("ȸ��Ż��");
		mobwith.setSize(105, 35);
		mobwith.setLocation(320, 155);
		mobwith.setBackground(Color.WHITE);
		mobwith.addActionListener(new modifyEvent());

		modbback = new Button("���ư���");
		modbback.setSize(105, 35);
		modbback.setLocation(320, 110);
		modbback.addActionListener(new modifyEvent());

		Mdok = new Dialog(Body, "ȸ������ ����Ϸ�", true);
		Mdok.setSize(240, 100);
		Mdok.setLocationRelativeTo(null);
		Mdok.setLayout(null);
		Mdok.addWindowListener(new MdokExit());

		Mlok = new Label("ȸ������ ������ ����Ǿ����ϴ�.", Label.CENTER);
		Mlok.setBounds(25, 40, 190, 20);

		mbok = new Button("�Ϸ�");
		mbok.setSize(50, 30);
		mbok.setLocation(75, 60);
		mbok.addActionListener(new modifyEvent());
		Mdok.add(Mlok);
		Mdok.add(mbok);

		Mdok.setVisible(false);

		Fwith = new Frame("ȸ��Ż��");
		Fwith.setSize(300, 400);
		Fwith.setLayout(null);
		Fwith.setAlwaysOnTop(true);
		Fwith.setLocationByPlatform(isLocationByPlatform());
		Fwith.addWindowListener(new withEvent());

		Wlreason = new Label("Ż���Ϸ��� ������ �����ֽø� �����ϰڽ��ϴ�.", Label.LEFT);
		Wlreason.setBounds(20, 30, 260, 20);
		Wtfreason = new TextField();
		Wtfreason.setSize(250, 200);
		Wtfreason.setLocation(25, 160);
		Wtfreason.setEditable(false);

		Wbsubmit = new Button("�����ϱ�");
		Wbsubmit.setSize(100, 30);
		Wbsubmit.setLocation(100, 360);
		Wbsubmit.addActionListener(new withEvent());

		ch1 = new Checkbox("����� ������");
		ch1.setLocation(20, 50);
		ch1.setSize(200, 20);
		ch1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s1 = 1000;
				} else
					s1 = 0;
			}
		});
		ch2 = new Checkbox("������ ����");
		ch2.setLocation(20, 70);
		ch2.setSize(200, 20);
		ch2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s2 = 200;
				} else
					s2 = 0;
			}
		});
		ch3 = new Checkbox("�������� ����");
		ch3.setLocation(20, 90);
		ch3.setSize(200, 20);
		ch3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s3 = 30;
				} else
					s3 = 0;
			}
		});
		ch4 = new Checkbox("���� ������ ����");
		ch4.setLocation(20, 110);
		ch4.setSize(200, 20);
		ch4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s4 = 4;
				} else
					s4 = 0;
			}
		});
		ch5 = new Checkbox("��Ÿ ����");
		ch5.setLocation(20, 130);
		ch5.setSize(200, 20);
		ch5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					Wtfreason.setEditable(true);
				} else
					Wtfreason.setEditable(false);
			}
		});

		WsDok = new Dialog(Body, "ȸ��Ż�� ����", true);
		WsDok.setSize(200, 100);
		WsDok.setLocationRelativeTo(null);
		WsDok.setLayout(new FlowLayout());
		WsDok.addWindowListener(new exitExit());
		WsDok.setAlwaysOnTop(true);

		WsDlok = new Label("ȸ��Ż�� �Ϸ�Ǿ����ϴ�.", Label.CENTER);

		WsDbok = new Button("���α׷� ����");
		WsDbok.addActionListener(new withEvent());

		WsDok.add(WsDlok);
		WsDok.add(WsDbok);
		WsDok.setVisible(false);
		/////////////////////////////////////

		///////////////////////////////////
		mHgive.addActionListener(new bodyFrameEvent());
		Fgive = new Frame("���α׷� ��������");
		Fgive.setSize(500, 300);
		Fgive.setLayout(null);
		Fgive.setAlwaysOnTop(true);
		Fgive.setLocationRelativeTo(null);

		Glreason = new Label("����� ������ �ǰ� �����մϴ�.", Label.CENTER);
		Glreason.setBounds(0, 30, 500, 40);
		Gtfreason = new TextField();
		Gtfreason.setSize(250, 200);
		Gtfreason.setLocation(25, 160);
		Gtfreason.setEditable(false);

		Gbsubmit = new Button("�����ϱ�");
		Gbsubmit.setSize(100, 30);
		Gbsubmit.setLocation(200, 260);
		Gbsubmit.addActionListener(new giveEvent());

		Gtfreason = new TextField();
		Gtfreason.setLocation(20, 140);
		Gtfreason.setSize(460, 115);
		Gtfreason.addActionListener(new giveEvent());
		Gtfreason.setEditable(false);

		Gch1 = new Checkbox("����� ������");
		Gch1.setLocation(20, 70);
		Gch1.setSize(200, 20);
		Gch1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s1 = 1000;
				} else
					s1 = 0;
			}
		});
		Gch2 = new Checkbox("������ ����");
		Gch2.setLocation(220, 70);
		Gch2.setSize(200, 20);
		Gch2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s2 = 200;
				} else
					s2 = 0;
			}
		});
		Gch3 = new Checkbox("�������� ����");
		Gch3.setLocation(20, 90);
		Gch3.setSize(200, 20);
		Gch3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s3 = 30;
				} else
					s3 = 0;
			}
		});
		Gch4 = new Checkbox("���� ���׿� ����");
		Gch4.setLocation(220, 90);
		Gch4.setSize(200, 20);
		Gch4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					s4 = 4;
				} else
					s4 = 0;
			}
		});
		Gch5 = new Checkbox("��Ÿ ����");
		Gch5.setLocation(20, 110);
		Gch5.setSize(200, 20);
		Gch5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					Gtfreason.setEditable(true);
				} else
					Gtfreason.setEditable(false);
			}
		});

		Gok = new Dialog(Fgive, "�����մϴ� \\ * 3 * //", true);
		Gok.setSize(200, 100);
		Gok.setLocationRelativeTo(null);
		Gok.setLayout(new FlowLayout());
		Gok.addWindowListener(new GokExit());
		Gok.setAlwaysOnTop(true);

		Glok = new Label("������ �ǰ� �ļӿ� ����ڽ��ϴ�.", Label.CENTER);

		Gbok = new Button("���ư���");
		Gbok.addActionListener(new giveEvent());
		Gbok.addKeyListener(new giveEvent());

		Gok.add(Glok);
		Gok.add(Gbok);
		Gok.setVisible(false);

		Fgive.add(Glreason);
		Fgive.add(Gtfreason);
		Fgive.add(Gbsubmit);
		Fgive.add(Gch1);
		Fgive.add(Gch2);
		Fgive.add(Gch3);
		Fgive.add(Gch4);
		Fgive.add(Gch5);

		Fgive.addWindowListener(new giveEvent());
		////////////////////////////////////
//		mHother.addActionListener(new bodyFrameEvent());
		Fother = new Frame("others..");
		Fother.setSize(500, 300);
		Fother.setLayout(null);
		Fother.addWindowListener(new otherExit());
		Fother.setAlwaysOnTop(isAlwaysOnTop());
		Fother.setAlwaysOnTop(true);
		///////////////////////////////////////
		marketPanelFont1 = new Font("Timesroman", Font.BOLD, 17);
		marketPanelFont2 = new Font("Timesroman", Font.BOLD, 19);
		marketPanelFont3 = new Font("Timesroman", Font.BOLD, 15);
		String dShow = "";
		Urlreader showM = new Urlreader();
		try {
			dShow = showM.showMarket();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Pmarket = new Panel();
		Pmarket.setLayout(null);
		Pmarket.setBackground(Color.LIGHT_GRAY);
		Pmarket.setSize(1200, 50);
		Pmarket.setLocation(50, 740);
		Pmarket.setVisible(true);

		lbl1 = new Label("", Label.LEFT);
		lbl1.setBounds(200, 1, 190, 25);
		lbl2 = new Label("", Label.LEFT);
		lbl2.setBounds(550, 1, 340, 25);
		lbl3 = new Label(dShow, Label.LEFT);
		lbl3.setBounds(50, 25, 970, 25);

		lbl1.setFont(marketPanelFont1);
		lbl2.setFont(marketPanelFont2);
		lbl3.setFont(marketPanelFont3);

		Bre = new Button("RE");
		Bre.setSize(30, 20);
		Bre.setLocation(1020, 25);
		Bre.addActionListener(new bodyFrameEvent());
		Bre.addKeyListener(new SimpleKeyListener());

		Pmarket.add(lbl1);
		Pmarket.add(lbl2);
		Pmarket.add(lbl3);
		Pmarket.add(Bre);
		////////////
		Fonttable1 = new Font("Timesroman", Font.BOLD, 14);
		Pleft = new Panel();
		Pleft.setLayout(null);
		Pleft.setBackground(new Color(224, 224, 224));
		Pleft.setSize(150, 545);
		Pleft.setLocation(10, 130);
		Pleft.setVisible(false);
		Pupper = new Panel();
		Pupper.setLayout(null);
		Pupper.setBackground(new Color(224, 224, 224));
		Pupper.setSize(830, 60);
		Pupper.setLocation(160, 68);
		Pupper.setVisible(false);
		Pinfo1 = new Panel();
		Pinfo1.setLayout(null);
		Pinfo1.setBackground(Color.white);
		Pinfo1.setSize(830, 545);
		Pinfo1.setLocation(162, 130);
		Pinfo1.setVisible(false);

		Lmaechul = new Label("�����(���)", Label.CENTER);
		Lmaechul.setBounds(0, 10, 150, 30);
		Lmaechul.setFont(Fonttable1);
		Lmaechul.addMouseListener(new maechulClickEvent());

		Lyounup = new Label("��������(���)", Label.CENTER);
		Lyounup.setBounds(0, 45, 150, 30);
		Lyounup.setFont(Fonttable1);
		Lyounup.addMouseListener(new younupClickEvent());

		Ldangi = new Label("��������(���)", Label.CENTER);
		Ldangi.setBounds(0, 80, 150, 30);
		Ldangi.setFont(Fonttable1);
		Ldangi.addMouseListener(new dangiClickEvent());

		Lyoungupper = new Label("����������(%)", Label.CENTER);
		Lyoungupper.setBounds(0, 115, 150, 30);
		Lyoungupper.setFont(Fonttable1);
		Lyoungupper.addMouseListener(new youngupperClickEvent());

		Lsoon = new Label("��������(%)", Label.CENTER);
		Lsoon.setBounds(0, 150, 150, 30);
		Lsoon.setFont(Fonttable1);
		Lsoon.addMouseListener(new soonClickEvent());

		Ljibae = new Label("ROE(%)", Label.CENTER);
		Ljibae.setBounds(0, 185, 150, 30);
		Ljibae.setFont(Fonttable1);
		Ljibae.addMouseListener(new jibaeClickEvent());

		Lbuchae = new Label("��ä����(%)", Label.CENTER);
		Lbuchae.setBounds(0, 220, 150, 30);
		Lbuchae.setFont(Fonttable1);
		Lbuchae.addMouseListener(new buchaeClickEvent());

		Ldangjwa = new Label("���º���(%)", Label.CENTER);
		Ldangjwa.setBounds(0, 255, 150, 30);
		Ldangjwa.setFont(Fonttable1);
		Ldangjwa.addMouseListener(new dangjwaClickEvent());

		Lyubo = new Label("������(%)", Label.CENTER);
		Lyubo.setBounds(0, 290, 150, 30);
		Lyubo.setFont(Fonttable1);
		Lyubo.addMouseListener(new yuboClickEvent());

		Leps = new Label("EPS(��)", Label.CENTER);
		Leps.setBounds(0, 325, 150, 30);
		Leps.setFont(Fonttable1);
		Leps.addMouseListener(new epsClickEvent());

		Lper = new Label("PER(��)", Label.CENTER);
		Lper.setBounds(0, 360, 150, 30);
		Lper.setFont(Fonttable1);
		Lper.addMouseListener(new perClickEvent());

		Lbps = new Label("BPS(��)", Label.CENTER);
		Lbps.setBounds(0, 395, 150, 30);
		Lbps.setFont(Fonttable1);
		Lbps.addMouseListener(new bpsClickEvent());

		Lpbr = new Label("PBR(��)", Label.CENTER);
		Lpbr.setBounds(0, 430, 150, 30);
		Lpbr.setFont(Fonttable1);
		Lpbr.addMouseListener(new pbrClickEvent());

		Ldivwon = new Label("�ִ����(��)", Label.CENTER);
		Ldivwon.setBounds(0, 465, 150, 30);
		Ldivwon.setFont(Fonttable1);
		Ldivwon.addMouseListener(new divwonClickEvent());

		Ldivper = new Label("�ð������(%)", Label.CENTER);
		Ldivper.setBounds(0, 500, 150, 30);
		Ldivper.setFont(Fonttable1);
		Ldivper.addMouseListener(new divperClickEvent());

		Lyear = new Label("�ֱ� ���� ����", Label.CENTER);
		Lyear.setBounds(0, 0, 320, 30);
		Lyear.setFont(Fonttable1);
		Lque = new Label("�ֱ� �б� ����", Label.CENTER);
		Lque.setBounds(320, 0, 490, 30);
		Lque.setFont(Fonttable1);
		L1812 = new Label("2018.12", Label.CENTER);
		L1812.setBounds(0, 30, 80, 30);
		L1812.setFont(Fonttable1);
		L1912 = new Label("2019.12", Label.CENTER);
		L1912.setBounds(80, 30, 80, 30);
		L1912.setFont(Fonttable1);
		L2012 = new Label("2020.12", Label.CENTER);
		L2012.setBounds(160, 30, 80, 30);
		L2012.setFont(Fonttable1);
		L202112 = new Label("2021.12(E)", Label.CENTER);
		L202112.setBounds(240, 30, 80, 30);
		L202112.setFont(Fonttable1);
		Lq2003 = new Label("2020.03", Label.CENTER);
		Lq2003.setBounds(320, 30, 80, 30);
		Lq2003.setFont(Fonttable1);
		Lq2006 = new Label("2020.06", Label.CENTER);
		Lq2006.setBounds(400, 30, 80, 30);
		Lq2006.setFont(Fonttable1);
		Lq2009 = new Label("2020.09", Label.CENTER);
		Lq2009.setBounds(480, 30, 80, 30);
		Lq2009.setFont(Fonttable1);
		Lq2012 = new Label("2020.12", Label.CENTER);
		Lq2012.setBounds(560, 30, 80, 30);
		Lq2012.setFont(Fonttable1);
		Lq2103 = new Label("2021.03", Label.CENTER);
		Lq2103.setBounds(640, 30, 80, 30);
		Lq2103.setFont(Fonttable1);
		Lq2106 = new Label("2020.06", Label.CENTER);
		Lq2106.setBounds(720, 30, 80, 30);
		Lq2106.setFont(Fonttable1);
		Fonttable2 = new Font("Timesroman", Font.BOLD, 14);
		Fonttable4 = new Font("Timesroman", Font.BOLD, 17);

		for (int i = 0; i < 10; i++) {
			Lmaechulnum[i] = new Label("", Label.CENTER);
			Lmaechulnum[i].setBounds(0 + 80 * i, 10, 80, 30);
			Lmaechulnum[i].setFont(Fonttable2);
			Lyounupnum[i] = new Label("", Label.CENTER);
			Lyounupnum[i].setBounds(0 + 80 * i, 45, 80, 30);
			Lyounupnum[i].setFont(Fonttable2);
			Ldanginum[i] = new Label("", Label.CENTER);
			Ldanginum[i].setBounds(0 + 80 * i, 80, 80, 30);
			Ldanginum[i].setFont(Fonttable2);
			Lyounguppernum[i] = new Label("", Label.CENTER);
			Lyounguppernum[i].setBounds(0 + 80 * i, 115, 80, 30);
			Lyounguppernum[i].setFont(Fonttable2);
			Lsoonnum[i] = new Label("", Label.CENTER);
			Lsoonnum[i].setBounds(0 + 80 * i, 150, 80, 30);
			Lsoonnum[i].setFont(Fonttable2);
			Ljibaenum[i] = new Label("", Label.CENTER);
			Ljibaenum[i].setBounds(0 + 80 * i, 185, 80, 30);
			Ljibaenum[i].setFont(Fonttable2);
			Lbuchaenum[i] = new Label("", Label.CENTER);
			Lbuchaenum[i].setBounds(0 + 80 * i, 220, 80, 30);
			Lbuchaenum[i].setFont(Fonttable2);
			Ldangjwanum[i] = new Label("", Label.CENTER);
			Ldangjwanum[i].setBounds(0 + 80 * i, 255, 80, 30);
			Ldangjwanum[i].setFont(Fonttable2);
			Lyubonum[i] = new Label("", Label.CENTER);
			Lyubonum[i].setBounds(0 + 80 * i, 290, 80, 30);
			Lyubonum[i].setFont(Fonttable2);
			Lepsnum[i] = new Label("", Label.CENTER);
			Lepsnum[i].setBounds(0 + 80 * i, 325, 80, 30);
			Lepsnum[i].setFont(Fonttable2);
			Lpernum[i] = new Label("", Label.CENTER);
			Lpernum[i].setBounds(0 + 80 * i, 360, 80, 30);
			Lpernum[i].setFont(Fonttable2);
			Lbpsnum[i] = new Label("", Label.CENTER);
			Lbpsnum[i].setBounds(0 + 80 * i, 395, 80, 30);
			Lbpsnum[i].setFont(Fonttable2);
			Lpbrnum[i] = new Label("", Label.CENTER);
			Lpbrnum[i].setBounds(0 + 80 * i, 430, 80, 30);
			Lpbrnum[i].setFont(Fonttable2);
			Ldivwonnum[i] = new Label("", Label.CENTER);
			Ldivwonnum[i].setBounds(0 + 80 * i, 465, 80, 30);
			Ldivwonnum[i].setFont(Fonttable2);
			Ldivpernum[i] = new Label("", Label.CENTER);
			Ldivpernum[i].setBounds(0 + 80 * i, 500, 80, 30);
			Ldivpernum[i].setFont(Fonttable2);
		}
		//////////////////////////////////////
		DInterWarning = new Dialog(Body, "�������� ����", true);
		DInterWarning.setLocationRelativeTo(null);
		DInterWarning.setSize(270, 110);
		DInterWarning.setLayout(null);
		DLwarningOk = new Label("�������� �̹� �ְų�, 10�� �ʰ���!!", Label.CENTER);
		DLwarningOk.setBounds(0, 35, 270, 25);
		DInterWarning.setVisible(false);

		DBwarningOk = new Button("Ȯ��");
		DBwarningOk.setLocation(95, 65);
		DBwarningOk.setSize(80, 30);
		DBwarningOk.addActionListener(new DBwarningOk());

		DInterWarning.add(DLwarningOk);
		DInterWarning.add(DBwarningOk);

		IBrefresh = new Button("F5");
		IBrefresh.setLocation(220, 10);
		IBrefresh.setSize(35, 30);
		IBrefresh.addActionListener(new AddEvent());

		InterNamefont = new Font("���", Font.BOLD, 24);
		InterPricefont = new Font("���", Font.PLAIN, 20);
		for (int i = 0; i < 10; i++) {
			InterName[i] = new Label("", Label.LEFT);
			InterName[i].setBounds(7, 15 + 65 * i, 170, 30);
			InterName[i].setFont(InterNamefont);
			InterNowprice[i] = new Label("", Label.LEFT);
			InterNowprice[i].setBounds(30, 45 + 65 * i, 80, 30);
			InterNowprice[i].setFont(InterPricefont);
			Interupdown[i] = new Label("", Label.CENTER);
			Interupdown[i].setBounds(120, 45 + 65 * i, 20, 30);
			Interupdown[i].setFont(InterPricefont);
			Interdiffprice[i] = new Label("", Label.LEFT);
			Interdiffprice[i].setBounds(150, 45 + 65 * i, 70, 30);
			Interdiffprice[i].setFont(InterPricefont);
			IbMinus[i] = new Button("-" + (i + 1));
			IbMinus[i].setLocation(220, 45 + 65 * i);
			IbMinus[i].setSize(25, 20);
			IbMinus[i].setVisible(false);
			IbMinus[i].addActionListener(new AddEvent());
			InterestGoalstate[i] = new Label("", Label.CENTER);
			InterestGoalstate[i].setBounds(180, 15 + 65 * i, 35, 30);
			InterestGoalstate[i].setFont(InterPricefont);
		}
		//////////////////////////////////////
		Body.setMenuBar(menuBar);
		Mdpwd.add(MdLpw);
		Mdpwd.add(Mtfpwd);
		Mdpwd.add(Mbpwd);
		Fmodify.add(modlid);
		Fmodify.add(modtfid);
		Fmodify.add(modlpw);
		Fmodify.add(modtfpw);
		Fmodify.add(modlemail);
		Fmodify.add(modtfemail);
		Fmodify.add(modbmod);
		Fmodify.add(modbback);
		Fmodify.add(modlid);
		Fmodify.add(mobwith);
		Fwith.add(Wbsubmit);
		Fwith.add(Wlreason);
		Fwith.add(Wtfreason);
		Fwith.add(ch1);
		Fwith.add(ch2);
		Fwith.add(ch3);
		Fwith.add(ch4);
		Fwith.add(ch5);
		Body.add(Pfin);
		Body.add(Pmarket);
		Body.add(Pinterest);
		Pleft.add(Lmaechul);
		Pleft.add(Lyounup);
		Pleft.add(Ldangi);
		Pleft.add(Lyoungupper);
		Pleft.add(Lsoon);
		Pleft.add(Ljibae);
		Pleft.add(Lbuchae);
		Pleft.add(Ldangjwa);
		Pleft.add(Lyubo);
		Pleft.add(Leps);
		Pleft.add(Lper);
		Pleft.add(Lbps);
		Pleft.add(Lpbr);
		Pleft.add(Ldivwon);
		Pleft.add(Ldivper);
		Pupper.add(Lyear);
		Pupper.add(L1812);
		Pupper.add(L1912);
		Pupper.add(L2012);
		Pupper.add(L202112);
		Pupper.add(Lq2003);
		Pupper.add(Lq2006);
		Pupper.add(Lq2009);
		Pupper.add(Lq2012);
		Pupper.add(Lq2103);
		Pupper.add(Lq2106);
		Pupper.add(Lque);
		Pfin.add(Pleft);
		Pfin.add(Pinfo1);

		for (int i = 0; i < 10; i++) {
			Pinfo1.add(Lmaechulnum[i]);
			Pinfo1.add(Lyounupnum[i]);
			Pinfo1.add(Ldanginum[i]);
			Pinfo1.add(Lyounguppernum[i]);
			Pinfo1.add(Lsoonnum[i]);
			Pinfo1.add(Ljibaenum[i]);
			Pinfo1.add(Lbuchaenum[i]);
			Pinfo1.add(Ldangjwanum[i]);
			Pinfo1.add(Lyubonum[i]);
			Pinfo1.add(Lepsnum[i]);
			Pinfo1.add(Lpernum[i]);
			Pinfo1.add(Lbpsnum[i]);
			Pinfo1.add(Lpbrnum[i]);
			Pinterest.add(InterName[i]);
			Pinterest.add(InterNowprice[i]);
			Pinterest.add(Interupdown[i]);
			Pinterest.add(Interdiffprice[i]);
			Pinterest.add(IbMinus[i]);
			Pinterest.add(InterestGoalstate[i]);

		}
		for (int i = 0; i < 4; i++) {
			Pinfo1.add(Ldivwonnum[i]);
			Pinfo1.add(Ldivpernum[i]);
		}
		Pinterest.add(IBrefresh);
		Pfin.add(Pupper);
		/////////// ��ũ���
		CBDARK = new CheckboxMenuItem("��ũ���");
		CBDARK.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					darkmode = 1;
					System.out.println("dark mode on");
					Body.setBackground(Color.gray);
					Pfin.setBackground(Color.black);
					Pupper.setBackground(Color.black);
					Pleft.setBackground(Color.black);
					Pinfo1.setBackground(Color.black);
					Pmarket.setBackground(Color.black);
					lbl1.setForeground(Color.white);
					lbl1.setBackground(Color.black);
					lbl2.setForeground(Color.white);
					lbl2.setBackground(Color.black);
					lbl3.setForeground(Color.white);
					lbl3.setBackground(Color.black);
					Flprice.setForeground(Color.white);
					Flprice.setBackground(Color.black);
					Fly.setForeground(Color.white);
					Fly.setBackground(Color.black);

					Fissue.setBackground(Color.black);
					Istop.setBackground(Color.black);
					Iissue.setBackground(Color.black);
					Iissue.setForeground(Color.white);
					Ilow.setBackground(Color.black);
					Ilow.setForeground(Color.white);
					Ireport.setBackground(Color.black);
					Ireport.setForeground(Color.white);
					Imid.setBackground(Color.black);
					Imid.setForeground(Color.white);
					Ihigh.setBackground(Color.black);
					Ihigh.setForeground(Color.white);
					Idanger.setBackground(Color.black);
					IstopChar.setBackground(Color.black);
					IissueChar.setBackground(Color.black);
					IissueChar.setForeground(Color.white);
					IlowChar.setBackground(Color.black);
					IlowChar.setForeground(Color.white);
					IreportChar.setBackground(Color.black);
					IreportChar.setForeground(Color.white);
					ImidChar.setBackground(Color.black);
					ImidChar.setForeground(Color.white);
					IhighChar.setBackground(Color.black);
					IhighChar.setForeground(Color.white);
					IdangerChar.setBackground(Color.black);
					Pinterest.setBackground(Color.black);
					Fgive.setBackground(Color.black);
					Fmodify.setBackground(Color.black);
					Fwith.setBackground(Color.black);

					modlid.setBackground(Color.black);
					modlid.setForeground(Color.white);
					modlpw.setBackground(Color.black);
					modlpw.setForeground(Color.white);
					modlemail.setBackground(Color.black);
					modlemail.setForeground(Color.white);
					modtfid.setBackground(Color.black);
					modtfid.setForeground(Color.white);
					modtfpw.setBackground(Color.black);
					modtfpw.setForeground(Color.white);
					modtfemail.setBackground(Color.black);
					modtfemail.setForeground(Color.white);
					modbmod.setBackground(Color.black);
					modbmod.setForeground(Color.white);
					Mdpwd.setBackground(Color.black);
					Mbpwd.setBackground(Color.black);
					Mbpwd.setForeground(Color.white);
					MdLpw.setBackground(Color.black);
					MdLpw.setForeground(Color.white);
					Mtfpwd.setBackground(Color.black);
					Mtfpwd.setForeground(Color.white);
					modbback.setBackground(Color.black);
					modbback.setForeground(Color.white);
					mbok.setBackground(Color.black);
					mbok.setForeground(Color.white);
					Glreason.setBackground(Color.black);
					Glreason.setForeground(Color.white);
					ch1.setBackground(mbok.getBackground());
					ch1.setForeground(mbok.getForeground());
					ch2.setBackground(mbok.getBackground());
					ch2.setForeground(mbok.getForeground());
					ch3.setBackground(mbok.getBackground());
					ch3.setForeground(mbok.getForeground());
					ch4.setBackground(mbok.getBackground());
					ch4.setForeground(mbok.getForeground());
					ch5.setBackground(mbok.getBackground());
					ch5.setForeground(mbok.getForeground());
					Gch1.setBackground(mbok.getBackground());
					Gch1.setForeground(mbok.getForeground());
					Gch2.setBackground(mbok.getBackground());
					Gch2.setForeground(mbok.getForeground());
					Gch3.setBackground(mbok.getBackground());
					Gch3.setForeground(mbok.getForeground());
					Gch4.setBackground(mbok.getBackground());
					Gch4.setForeground(mbok.getForeground());
					Gch5.setBackground(mbok.getBackground());
					Gch5.setForeground(mbok.getForeground());
					Wlreason.setBackground(mbok.getBackground());
					Wlreason.setForeground(mbok.getForeground());
					Fgoal.setBackground(Color.black);
					GoalLupper.setForeground(Color.white);
					GoalLdowner.setForeground(Color.white);
					GoalLdelete.setForeground(Color.white);
					GoalLyourinterst.setForeground(Color.white);
					GoalLname.setForeground(Color.white);
					GoalLprice.setForeground(Color.white);
					GoalLupper.setBackground(Color.black);
					GoalLdowner.setBackground(Color.black);
					GoalLdelete.setBackground(Color.black);
					GoalLyourinterst.setBackground(Color.black);
					GoalLname.setBackground(new Color(224, 224, 224));
					GoalLprice.setBackground(new Color(224, 224, 224));

					for (int i = 0; i < 10; i++) {
						Lmaechulnum[i].setForeground(Color.white);
						Lmaechulnum[i].setBackground(Color.black);
						Lyounupnum[i].setForeground(Color.white);
						Lyounupnum[i].setBackground(Color.black);
						Ldanginum[i].setForeground(Color.white);
						Ldanginum[i].setBackground(Color.black);
						Lyounguppernum[i].setForeground(Color.white);
						Lyounguppernum[i].setBackground(Color.black);
						Lsoonnum[i].setForeground(Color.white);
						Lsoonnum[i].setBackground(Color.black);
						Ljibaenum[i].setForeground(Color.white);
						Ljibaenum[i].setBackground(Color.black);
						Lbuchaenum[i].setForeground(Color.white);
						Lbuchaenum[i].setBackground(Color.black);
						Ldangjwanum[i].setForeground(Color.white);
						Ldangjwanum[i].setBackground(Color.black);
						Lyubonum[i].setForeground(Color.white);
						Lyubonum[i].setBackground(Color.black);
						Lepsnum[i].setForeground(Color.white);
						Lepsnum[i].setBackground(Color.black);
						Lpernum[i].setForeground(Color.white);
						Lpernum[i].setBackground(Color.black);
						Lbpsnum[i].setForeground(Color.white);
						Lbpsnum[i].setBackground(Color.black);
						Lpbrnum[i].setForeground(Color.white);
						Lpbrnum[i].setBackground(Color.black);
						Ldivwonnum[i].setForeground(Color.white);
						Ldivwonnum[i].setBackground(Color.black);
						Ldivpernum[i].setForeground(Color.white);
						Ldivpernum[i].setBackground(Color.black);
						Lmaechul.setForeground(Color.white);
						Lmaechul.setBackground(Color.black);
						Lyounup.setForeground(Color.white);
						Lyounup.setBackground(Color.black);
						Ldangi.setForeground(Color.white);
						Ldangi.setBackground(Color.black);
						Lyoungupper.setForeground(Color.white);
						Lyoungupper.setBackground(Color.black);
						Lsoon.setForeground(Color.white);
						Lsoon.setBackground(Color.black);
						Ljibae.setForeground(Color.white);
						Ljibae.setBackground(Color.black);
						Lbuchae.setForeground(Color.white);
						Lbuchae.setBackground(Color.black);
						Ldangjwa.setForeground(Color.white);
						Ldangjwa.setBackground(Color.black);
						Lyubo.setForeground(Color.white);
						Lyubo.setBackground(Color.black);
						Leps.setForeground(Color.white);
						Leps.setBackground(Color.black);
						Lper.setForeground(Color.white);
						Lper.setBackground(Color.black);
						Lbps.setForeground(Color.white);
						Lbps.setBackground(Color.black);
						Lpbr.setForeground(Color.white);
						Lpbr.setBackground(Color.black);
						Ldivwon.setForeground(Color.white);
						Ldivwon.setBackground(Color.black);
						Ldivper.setForeground(Color.white);
						Ldivper.setBackground(Color.black);

						Lyear.setForeground(Color.white);
						Lyear.setBackground(Color.black);
						Lque.setForeground(Color.white);
						Lque.setBackground(Color.black);
						L1812.setForeground(Color.white);
						L1812.setBackground(Color.black);
						L1912.setForeground(Color.white);
						L1912.setBackground(Color.black);
						L2012.setForeground(Color.white);
						L2012.setBackground(Color.black);
						L202112.setForeground(Color.white);
						L202112.setBackground(Color.black);
						Lq2003.setForeground(Color.white);
						Lq2003.setBackground(Color.black);
						Lq2006.setForeground(Color.white);
						Lq2006.setBackground(Color.black);
						Lq2009.setForeground(Color.white);
						Lq2009.setBackground(Color.black);
						Lq2012.setForeground(Color.white);
						Lq2012.setBackground(Color.black);
						Lq2103.setForeground(Color.white);
						Lq2103.setBackground(Color.black);
						Lq2106.setForeground(Color.white);
						Lq2106.setBackground(Color.black);

						InterName[i].setBackground(Color.black);
						InterNowprice[i].setBackground(Color.black);
						Interupdown[i].setBackground(Color.black);
						Interdiffprice[i].setBackground(Color.black);
						InterName[i].setForeground(Color.white);
						InterNowprice[i].setForeground(Color.white);
						Interdiffprice[i].setForeground(Color.white);
						InterestGoalstate[i].setBackground(Color.black);
						GoalLinterestList[i].setForeground(Color.white);
						GoalLinterestList[i].setBackground(Color.black);
						GoalLnowprice[i].setBackground(Color.black);
						GoalLnowprice[i].setForeground(Color.white);

					}
				} else {
					darkmode = 0;
					System.out.println("dark mode off");
					Pinterest.setBackground(Color.orange);
					Flprice.setForeground(Color.black);
					Flprice.setBackground(Color.white);
					Fly.setForeground(Color.black);
					Fly.setBackground(Color.white);
					Body.setBackground(Color.white);
					Pfin.setBackground(Color.white);
					Pupper.setBackground(new Color(224, 224, 224));
					Pleft.setBackground(new Color(224, 224, 224));
					Pinfo1.setBackground(Color.white);
					Pmarket.setBackground(new Color(224, 224, 224));
					lbl1.setForeground(Color.black);
					lbl1.setBackground(new Color(224, 224, 224));
					lbl2.setForeground(Color.black);
					lbl2.setBackground(new Color(224, 224, 224));
					lbl3.setForeground(Color.black);
					lbl3.setBackground(new Color(224, 224, 224));
					Fissue.setBackground(Color.white);
					Istop.setBackground(Color.white);
					Iissue.setBackground(Color.white);
					Iissue.setForeground(Color.black);
					Ilow.setBackground(Color.white);
					Ilow.setForeground(Color.black);
					Ireport.setBackground(Color.white);
					Ireport.setForeground(Color.black);
					Imid.setBackground(Color.white);
					Imid.setForeground(Color.black);
					Ihigh.setBackground(Color.white);
					Ihigh.setForeground(Color.black);
					Idanger.setBackground(Color.white);
					IstopChar.setBackground(Color.white);
					IissueChar.setBackground(Color.white);
					IissueChar.setForeground(Color.black);
					IlowChar.setBackground(Color.white);
					IlowChar.setForeground(Color.black);
					IreportChar.setBackground(Color.white);
					IreportChar.setForeground(Color.black);
					ImidChar.setBackground(Color.white);
					ImidChar.setForeground(Color.black);
					IhighChar.setBackground(Color.white);
					IhighChar.setForeground(Color.black);
					IdangerChar.setBackground(Color.white);
					Fgive.setBackground(Color.white);
					Fmodify.setBackground(Color.white);
					Fwith.setBackground(Color.white);
					modlid.setBackground(Color.white);
					modlid.setForeground(Color.black);
					modlid.setBackground(Color.white);
					modlid.setForeground(Color.black);
					modlpw.setBackground(modlid.getBackground());
					modlpw.setForeground(modlid.getForeground());
					modlemail.setBackground(modlid.getBackground());
					modlemail.setForeground(Color.white);
					modtfid.setBackground(modlid.getBackground());
					modtfid.setForeground(modlid.getForeground());
					modtfpw.setBackground(modlid.getBackground());
					modtfpw.setForeground(modlid.getForeground());
					modtfemail.setBackground(modlid.getBackground());
					modtfemail.setForeground(modlid.getForeground());
					modbmod.setBackground(modlid.getBackground());
					modbmod.setForeground(modlid.getForeground());
					Mdpwd.setBackground(modlid.getBackground());
					Mbpwd.setBackground(modlid.getBackground());
					Mbpwd.setForeground(modlid.getForeground());
					MdLpw.setBackground(modlid.getBackground());
					MdLpw.setForeground(modlid.getForeground());
					Mtfpwd.setBackground(modlid.getBackground());
					Mtfpwd.setForeground(modlid.getForeground());
					modbback.setBackground(modlid.getBackground());
					modbback.setForeground(modlid.getForeground());
					mbok.setBackground(modlid.getBackground());
					mbok.setForeground(modlid.getForeground());
					Glreason.setBackground(modlid.getBackground());
					Glreason.setForeground(modlid.getForeground());
					ch1.setBackground(modlid.getBackground());
					ch1.setForeground(modlid.getForeground());
					ch2.setBackground(modlid.getBackground());
					ch2.setForeground(modlid.getForeground());
					ch3.setBackground(modlid.getBackground());
					ch3.setForeground(modlid.getForeground());
					ch4.setBackground(modlid.getBackground());
					ch4.setForeground(modlid.getForeground());
					ch5.setBackground(modlid.getBackground());
					ch5.setForeground(modlid.getForeground());
					Gch1.setBackground(mbok.getBackground());
					Gch1.setForeground(mbok.getForeground());
					Gch2.setBackground(mbok.getBackground());
					Gch2.setForeground(mbok.getForeground());
					Gch3.setBackground(mbok.getBackground());
					Gch3.setForeground(mbok.getForeground());
					Gch4.setBackground(mbok.getBackground());
					Gch4.setForeground(mbok.getForeground());
					Gch5.setBackground(mbok.getBackground());
					Gch5.setForeground(mbok.getForeground());
					Wlreason.setBackground(modlid.getBackground());
					Wlreason.setForeground(modlid.getForeground());
					Fgoal.setBackground(Color.white);
					GoalLupper.setForeground(Color.black);
					GoalLdowner.setForeground(Color.black);
					GoalLdelete.setForeground(Color.black);
					GoalLyourinterst.setForeground(Color.black);
					GoalLname.setForeground(Color.black);
					GoalLprice.setForeground(Color.black);
					GoalLupper.setBackground(Color.white);
					GoalLdowner.setBackground(Color.white);
					GoalLdelete.setBackground(Color.white);
					GoalLyourinterst.setBackground(Color.white);
					GoalLname.setBackground(new Color(224, 224, 224));
					GoalLprice.setBackground(new Color(224, 224, 224));
					for (int i = 0; i < 10; i++) {
						Lmaechulnum[i].setForeground(Color.black);
						Lmaechulnum[i].setBackground(Color.white);
						Lyounupnum[i].setForeground(Color.black);
						Lyounupnum[i].setBackground(Color.white);
						Ldanginum[i].setForeground(Color.black);
						Ldanginum[i].setBackground(Color.white);
						Lyounguppernum[i].setForeground(Color.black);
						Lyounguppernum[i].setBackground(Color.white);
						Lsoonnum[i].setForeground(Color.black);
						Lsoonnum[i].setBackground(Color.white);
						Ljibaenum[i].setForeground(Color.black);
						Ljibaenum[i].setBackground(Color.white);
						Lbuchaenum[i].setForeground(Color.black);
						Lbuchaenum[i].setBackground(Color.white);
						Ldangjwanum[i].setForeground(Color.black);
						Ldangjwanum[i].setBackground(Color.white);
						Lyubonum[i].setForeground(Color.black);
						Lyubonum[i].setBackground(Color.white);
						Lepsnum[i].setForeground(Color.black);
						Lepsnum[i].setBackground(Color.white);
						Lpernum[i].setForeground(Color.black);
						Lpernum[i].setBackground(Color.white);
						Lbpsnum[i].setForeground(Color.black);
						Lbpsnum[i].setBackground(Color.white);
						Lpbrnum[i].setForeground(Color.black);
						Lpbrnum[i].setBackground(Color.white);
						Ldivwonnum[i].setForeground(Color.black);
						Ldivwonnum[i].setBackground(Color.white);
						Ldivpernum[i].setForeground(Color.black);
						Ldivpernum[i].setBackground(Color.white);
						Lmaechul.setForeground(Color.black);
						Lmaechul.setBackground(new Color(224, 224, 224));
						Lyounup.setForeground(Color.black);
						Lyounup.setBackground(new Color(224, 224, 224));
						Ldangi.setForeground(Color.black);
						Ldangi.setBackground(new Color(224, 224, 224));
						Lyoungupper.setForeground(Color.black);
						Lyoungupper.setBackground(new Color(224, 224, 224));
						Lsoon.setForeground(Color.black);
						Lsoon.setBackground(new Color(224, 224, 224));
						Ljibae.setForeground(Color.black);
						Ljibae.setBackground(new Color(224, 224, 224));
						Lbuchae.setForeground(Color.black);
						Lbuchae.setBackground(new Color(224, 224, 224));
						Ldangjwa.setForeground(Color.black);
						Ldangjwa.setBackground(new Color(224, 224, 224));
						Lyubo.setForeground(Color.black);
						Lyubo.setBackground(new Color(224, 224, 224));
						Leps.setForeground(Color.black);
						Leps.setBackground(new Color(224, 224, 224));
						Lper.setForeground(Color.black);
						Lper.setBackground(new Color(224, 224, 224));
						Lbps.setForeground(Color.black);
						Lbps.setBackground(new Color(224, 224, 224));
						Lpbr.setForeground(Color.black);
						Lpbr.setBackground(new Color(224, 224, 224));
						Ldivwon.setForeground(Color.black);
						Ldivwon.setBackground(new Color(224, 224, 224));
						Ldivper.setForeground(Color.black);
						Ldivper.setBackground(new Color(224, 224, 224));

						Lyear.setForeground(Color.black);
						Lyear.setBackground(new Color(224, 224, 224));
						Lque.setForeground(Color.black);
						Lque.setBackground(new Color(224, 224, 224));
						L1812.setForeground(Color.black);
						L1812.setBackground(new Color(224, 224, 224));
						L1912.setForeground(Color.black);
						L1912.setBackground(new Color(224, 224, 224));
						L2012.setForeground(Color.black);
						L2012.setBackground(new Color(224, 224, 224));
						L202112.setForeground(Color.black);
						L202112.setBackground(new Color(224, 224, 224));
						Lq2003.setForeground(Color.black);
						Lq2003.setBackground(new Color(224, 224, 224));
						Lq2006.setForeground(Color.black);
						Lq2006.setBackground(new Color(224, 224, 224));
						Lq2009.setForeground(Color.black);
						Lq2009.setBackground(new Color(224, 224, 224));
						Lq2012.setForeground(Color.black);
						Lq2012.setBackground(new Color(224, 224, 224));
						Lq2103.setForeground(Color.black);
						Lq2103.setBackground(new Color(224, 224, 224));
						Lq2106.setForeground(Color.black);
						Lq2106.setBackground(new Color(224, 224, 224));

						InterName[i].setBackground(Color.orange);
						InterNowprice[i].setBackground(Color.orange);
						Interupdown[i].setBackground(Color.orange);
						Interdiffprice[i].setBackground(Color.orange);
						InterName[i].setForeground(Color.black);
						InterNowprice[i].setForeground(Color.black);
						Interdiffprice[i].setForeground(Color.black);
						InterestGoalstate[i].setBackground(Color.orange);
						GoalLinterestList[i].setForeground(Color.black);
						GoalLinterestList[i].setBackground(Color.white);
						GoalLnowprice[i].setBackground(Color.white);
						GoalLnowprice[i].setForeground(Color.black);

					}
				}
			}
		});
		Fonttable3 = new Font("��������ڵ�", Font.BOLD, 19);
		CBMinterest = new CheckboxMenuItem("��������");
		CBMinterest.addItemListener(new ItemListener() {
			@Override
			////// üũ�ڽ��������� �ʱ� ȭ������ ����Ȱ���� ä��� �۾�
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == 1) {
					dao = new MemberDAO();
					Loginlist = dao.Search_login_list(id);
					Logininfo logdata = (Logininfo) Loginlist.get(0);
					if (logdata.getLogoffnow() == 1) {
						System.out.println("�����α׿����Ȱ��");
						DduplicateLogoff.setVisible(true);
					} else if (logdata.getLogoffnow() == 2) {
						Pinterest.setVisible(true);
						shareslist = sharesDao.interest_MAX_cnt(id);
						sharesVo data = new sharesVo();
						data = (sharesVo) shareslist.get(0);
						sharesDao.Load_user_interest_list(id, data.getCnt());
						String userInteresteddata[] = data.getInterest_user_shares();
						int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
						int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������

						for (int i = 0; i < data.getCnt(); i++) {
							System.out.println(userInteresteddata[i]);
							InterName[i].setText(userInteresteddata[i]);
							try {
								Urlreader reader = new Urlreader(InterName[i].getText());
								int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
								InterNowprice[i].setText(reader.getPrice());
								if (reader.getYday().equals("���")) {
									Interupdown[i].setForeground(Color.red);
									Interupdown[i].setText("��");
								} else if (reader.getYday().equals("����")) {
									Interupdown[i].setText("-");
								} else {
									Interupdown[i].setForeground(Color.blue);
									Interupdown[i].setText("��");
								}
								if (targetupdown[i] != 0) {
									if (targetupdown[i] == 1) {
										if (numberprice >= targetPrice[i]) {
											InterestGoalstate[i].setText("�ݡ�");
											InterestGoalstate[i].setForeground(Color.red);
										} else {
											InterestGoalstate[i].setText("");
										}
									} else if (targetupdown[i] == 2) {
										if (targetPrice[i] >= numberprice) {
											InterestGoalstate[i].setText("�ݡ�");
											InterestGoalstate[i].setForeground(Color.blue);
										} else {
											InterestGoalstate[i].setText("");
										}
									}

								} else {
									System.out.println("�ΰ���");
									InterestGoalstate[i].setText("");
								}
								Interdiffprice[i].setText(reader.getYprice());
								IbMinus[i].setVisible(true);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (NumberFormatException e2) {
								e2.printStackTrace();
							}
						}
						for (int i = data.getCnt(); i < 10; i++) {
							InterName[i].setText("");
							InterNowprice[i].setText("");
							Interupdown[i].setText("");
							Interdiffprice[i].setText("");
							InterestGoalstate[i].setText("");
							IbMinus[i].setVisible(false);
						}
					} else {
						System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
					}

				} else {
					dao = new MemberDAO();
					System.out.println(id);
					Loginlist = dao.Search_login_list(id);
					Logininfo data = (Logininfo) Loginlist.get(0);
					if (data.getLogoffnow() == 1) {
						DduplicateLogoff.setVisible(true);
					} else if (data.getLogoffnow() == 2) {
						System.out.println("���� �α��εǾ�����");
					} else {
						System.out.println("�� ��û�� ���ܹ߻� : " + data.getLogoffnow());
					}
					Pinterest.setVisible(false);
				}
			}
		});
		pMenuBody = new PopupMenu("��������");

		pmF5 = new MenuItem("���ΰ�ħ", new MenuShortcut(KeyEvent.VK_R));
		pmF5.addActionListener(new popupEvent());
		pmGoal = new MenuItem("��ǥ�� ����");
		pmGoal.addActionListener(new popupEvent());
		pmShort = new MenuItem("���ŵ� ��Ȳ");
		pmShort.addActionListener(new popupEvent());
		pmNaver = new MenuItem("������й�", new MenuShortcut(KeyEvent.VK_R));
		pmNaver.addActionListener(new popupEvent());
		pmDart = new MenuItem("��Ʈ���� ����");
		pmDart.addActionListener(new popupEvent());
		pMenuBody.add(pmF5);
		pMenuBody.add(pmGoal);
		pMenuBody.addSeparator();
		pMenuBody.add(pmShort);
		pMenuBody.add(pmDart);
		pMenuBody.add(pmNaver);

		DduplicateLogoff = new Dialog(Body, "�α׿����ȳ�", true);
		DduplicateLogoff.setSize(300, 105);
		DduplicateLogoff.setLocationRelativeTo(null);
		DduplicateLogoff.setLayout(null);
		DduplicateLogoff.addWindowListener(new DuplicateLogout());

		DuplicateLok = new Label("�ٸ�����ڷκ��� �����α׿����Ǿ����ϴ�.", Label.CENTER);
		DuplicateLok.setBounds(0, 40, 300, 20);

		DuplicateBok = new Button("���α׷� ����");
		DuplicateBok.setLocation(88, 65);
		DuplicateBok.setSize(125, 30);
		DuplicateBok.addActionListener(new DuplicateLogout());

		DduplicateLogoff.add(DuplicateLok);
		DduplicateLogoff.add(DuplicateBok);

		Body.add(pMenuBody);
		Body.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getModifiers() == me.BUTTON3_MASK) {
					pMenuBody.show(Body, me.getX(), me.getY());
					dao = new MemberDAO();
					System.out.println(id);
					Loginlist = dao.Search_login_list(id);
					Logininfo data = (Logininfo) Loginlist.get(0);
					if (data.getLogoffnow() == 1) {
						DduplicateLogoff.setVisible(true);
					} else if (data.getLogoffnow() == 2) {
						System.out.println("���� �α��εǾ�����");
					} else {
						System.out.println("�� ��û�� ���ܹ߻� : " + data.getLogoffnow());
					}
				}
			}
		});
		Pfin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getModifiers() == me.BUTTON3_MASK) {
//					pMenuBody.show(Pfin, me.getX(), me.getY());
					dao = new MemberDAO();
					System.out.println(id);
					Loginlist = dao.Search_login_list(id);
					Logininfo data = (Logininfo) Loginlist.get(0);
					if (data.getLogoffnow() == 1) {
						DduplicateLogoff.setVisible(true);
					} else if (data.getLogoffnow() == 2) {
						pMenuBody.show(Pfin, me.getX(), me.getY());
						System.out.println("���� �α��εǾ�����");
					} else {
						System.out.println("�� ��û�� ���ܹ߻� : " + data.getLogoffnow());
					}
				}
			}
		});
		Pinterest.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent me) {
				if (me.getModifiers() == me.BUTTON3_MASK) {
					dao = new MemberDAO();
					System.out.println(id);
					Loginlist = dao.Search_login_list(id);
					Logininfo data = (Logininfo) Loginlist.get(0);
					if (data.getLogoffnow() == 1) {
						DduplicateLogoff.setVisible(true);
					} else if (data.getLogoffnow() == 2) {
						pMenuBody.show(Pinterest, me.getX(), me.getY());
						System.out.println("���� �α��εǾ�����");
					} else {
						System.out.println("�� ��û�� ���ܹ߻� : " + data.getLogoffnow());
					}
				}
			}
		});
		Pmarket.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getModifiers() == me.BUTTON3_MASK) {
					dao = new MemberDAO();
					System.out.println(id);
					Loginlist = dao.Search_login_list(id);
					Logininfo data = (Logininfo) Loginlist.get(0);
					if (data.getLogoffnow() == 1) {
						DduplicateLogoff.setVisible(true);
					} else if (data.getLogoffnow() == 2) {
						pMenuBody.show(Pmarket, me.getX(), me.getY());
						System.out.println("���� �α��εǾ�����");
					} else {
						System.out.println("�� ��û�� ���ܹ߻� : " + data.getLogoffnow());
					}
				}
			}
		});
		mUser.add(CBMinterest);
		mUser.add(mPgoal);
		mUser.addSeparator();
		mUser.add(mPmodify);

		mHelp.add(mHgive);
		mHelp.addSeparator();
//		mHelp.add(mHother);
		mHelp.add(mHlogout);
		mUser.add(CBDARK);
	}

	private boolean isAlwaysOnTop() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isLocationByPlatform() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public class bodyFrameEvent extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("���ŵ� ��Ȳ ����")) {
				Urlreader url = new Urlreader();
				if (Ftfsearch2.getText().equals("")) {
					url.StartSHORTUrl(null);
				} else {
					shareslist = sharesDao.select_shares_info(Ftfsearch2.getText().toUpperCase());
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					String code = data.getCode();
					url.StartSHORTUrl(code);
				}

			}
			if (e.getActionCommand().equals("������й�(NAVER)")) {
				Urlreader url = new Urlreader();
				if (Ftfsearch2.getText().equals("")) {
					url.StartDISCUSSUrl(null);
				} else {
					shareslist = sharesDao.select_shares_info(Ftfsearch2.getText().toUpperCase());
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					String code = data.getCode();
					url.StartDISCUSSUrl(code);
				}
			}
			if (e.getActionCommand().equals("��Ʈ(DART) ����Ȯ��")) {
				Urlreader url = new Urlreader();
				if (Ftfsearch2.getText().equals("")) {
					url.StartDARTUrl(null);
				} else {
					shareslist = sharesDao.select_shares_info(Ftfsearch2.getText());
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					String code = data.getCode();
					url.StartDARTUrl(code);
				}
			}
			if (e.getActionCommand().equals("��ǥ�� ����")) {
				Fgoal.setVisible(true);
				GoalLclicked.setText("");
				GoalLclicked.setBackground(Color.gray);
				//
				Loginlist = dao.Loginlist();
				Logininfo Logindata = (Logininfo) Loginlist.get(0);
				String nowId = Logindata.getId();
				shareslist = sharesDao.interest_MAX_cnt(nowId);
				sharesVo data = new sharesVo();
				data = (sharesVo) shareslist.get(0);
				sharesDao.Load_user_interest_list(nowId, data.getCnt());
				String userInteresteddata[] = data.getInterest_user_shares();
				for (int i = 0; i < data.getCnt(); i++) {
					System.out.println(userInteresteddata[i]);
					GoalLinterestList[i].setText(userInteresteddata[i]);
					try {
						Urlreader reader = new Urlreader(GoalLinterestList[i].getText());
						GoalLnowprice[i].setText(reader.getPrice());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				shareslist = sharesDao.interest_MAX_cnt(Logindata.getId());
				sharesVo newdata = new sharesVo();
				newdata = (sharesVo) shareslist.get(0);
				for (int i = newdata.getCnt(); i < 10; i++) {
					GoalLinterestList[i].setText("");
					GoalLnowprice[i].setText("");
				}
				//
			}
			if (e.getActionCommand().equals("���α׷� ��������")) {
				Fgive.setVisible(true);
			}
			if (e.getActionCommand().equals("others..")) {
				Fother.setVisible(true);
			}
			if (e.getActionCommand().equals("RE")) {
				String dShow = "";
				Urlreader showM = new Urlreader();
				try {
					dShow = showM.showMarket();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lbl3.setText(dShow);
			}
			if (e.getActionCommand().equals("�ŷ�����")) {
				Fissue.setVisible(true);
				shareslist = sharesDao.show_trade_val(LsearchSetting.getText().toUpperCase());
				sharesVo data = new sharesVo();
				data = (sharesVo) shareslist.get(0);
				IstopChar.setText(data.getIstop());
				IissueChar.setText(data.getIissue());
				IlowChar.setText(data.getIlow());
				IreportChar.setText(data.getIreport());
				ImidChar.setText(data.getImid());
				IhighChar.setText(data.getIhigh());
				IdangerChar.setText(data.getIdanger());
			}
			if (e.getSource() == Ftfsearch2 || e.getActionCommand().equals("�˻�")) {
				try {
					LsearchSetting.setText(Ftfsearch2.getText().toUpperCase());
					Urlreader reader = new Urlreader(LsearchSetting.getText().toUpperCase());
					sharesInfo si = new sharesInfo(LsearchSetting.getText().toUpperCase());
					Ftfprice.setText(reader.getPrice());
					Ftfy.setText(reader.getYday());
					Ftfyp.setText(reader.getYprice());
					Ftfp.setText(reader.getPercent() + "%");
					shareslist = sharesDao.show_trade_val(LsearchSetting.getText().toUpperCase());
					shareslist = sharesDao.show_market(LsearchSetting.getText().toUpperCase());
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					IstopChar.setText(data.getIstop());
					IissueChar.setText(data.getIissue());
					IlowChar.setText(data.getIlow());
					IreportChar.setText(data.getIreport());
					ImidChar.setText(data.getImid());
					IhighChar.setText(data.getIhigh());
					IdangerChar.setText(data.getIdanger());
					Fthmarket.setText(data.getMarket());
					for (int i = 0; i < 10; i++) {
						Lmaechulnum[i].setText(si.maechulprint[i]);
						Lyounupnum[i].setText(si.youngupprint[i]);
						Ldanginum[i].setText(si.dangiprint[i]);
						Lyounguppernum[i].setText(si.youngupPerprint[i]);
						Lsoonnum[i].setText(si.soonprint[i]);
						Ljibaenum[i].setText(si.jibaeprint[i]);
						Lbuchaenum[i].setText(si.buchaeprint[i]);
						Ldangjwanum[i].setText(si.dangjwaprint[i]);
						Lyubonum[i].setText(si.yuboprint[i]);
						Lepsnum[i].setText(si.epsprint[i]);
						Lpernum[i].setText(si.perprint[i]);
						Lbpsnum[i].setText(si.bpsprint[i]);
						Lpbrnum[i].setText(si.pbrprint[i]);
						Ldivwonnum[i].setText(si.divwonprint[i]);
						Ldivpernum[i].setText(si.divperprint[i]);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	public class programExit extends WindowAdapter implements KeyListener, ActionListener {

		public void windowIconified(WindowEvent we) {
			Fminiwindow.setSize(180, 300);
			Fminiwindow.setLocation(1350, 520);
			String id[] = Body.getTitle().split("��");
			Loginlist = dao.Search_login_list(id[0]);
			Logininfo logdata = (Logininfo) Loginlist.get(0);
			if (logdata.getLogoffnow() == 1) {
				DduplicateLogoff.setVisible(true);
			} else if (logdata.getLogoffnow() == 2) {
				shareslist = sharesDao.interest_MAX_cnt(id[0]);
				sharesVo data = new sharesVo();
				data = (sharesVo) shareslist.get(0);
				sharesDao.Load_user_interest_list(id[0], data.getCnt());
				String userInteresteddata[] = data.getInterest_user_shares();
				for (int i = 0; i < data.getCnt(); i++) {
					System.out.println(userInteresteddata[i]);
					MiniName[i].setText(userInteresteddata[i]);
					MiniName[i].setForeground(Color.black);
					try {
						Urlreader reader = new Urlreader(MiniName[i].getText());
						MiniNowprice[i].setText(reader.getPrice());
						if (reader.getYday().equals("���")) {
							MiniNowprice[i].setForeground(Color.red);
						} else if (reader.getYday().equals("����")) {
							MiniNowprice[i].setForeground(Color.black);
						} else {
							MiniNowprice[i].setForeground(Color.blue);
						}
					} catch (IOException e1) {
						e1.printStackTrace();

					} catch (NumberFormatException e2) {
						e2.printStackTrace();
					}
				}
				shareslist = sharesDao.interest_MAX_cnt(id[0]);
				sharesVo newdata = new sharesVo();
				newdata = (sharesVo) shareslist.get(0);
				for (int i = newdata.getCnt(); i < 10; i++) {
					MiniName[i].setText("");
					MiniNowprice[i].setText("");
				}
			} else {
				System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
			}
			Fminiwindow.setVisible(true);
		}

		public void windowDeiconified(WindowEvent we) {
			Fminiwindow.dispose();
		}

		public void windowActivated(WindowEvent we) {
		}

		public void windowDeactivated(WindowEvent we) {
		}

		public void windowClosing(WindowEvent we) {
			dao = new MemberDAO();
			String id[] = Body.getTitle().split("��");
			Loginlist = dao.Search_login_list(id[0]);
			Logininfo logdata = (Logininfo) Loginlist.get(0);
			if (logdata.getLogoffnow() == 1) {
				DduplicateLogoff.setVisible(true);
			} else if (logdata.getLogoffnow() == 2) {
				System.out.println("���� �α��εǾ�����");
				Dexit.setVisible(true);
			} else {
				System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == 10) {
				Loginlist = dao.Loginlist();
				Logininfo data2 = (Logininfo) Loginlist.get(0);
				String id = data2.getId();
				dao.Logout(id);
				System.exit(0);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("����")) {
				Loginlist = dao.Loginlist();
				Logininfo data = (Logininfo) Loginlist.get(0);
				String id = data.getId();
				dao.Logout(id);
				System.exit(0);
			}
		}
	}

	public class GokExit extends WindowAdapter implements ActionListener {
		public void windowClosing(WindowEvent we) {
			Gok.setVisible(false);
			Fgive.setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//
			if (e.getActionCommand().equals("\"�����մϴ� \\\\ * 3 * //\"")) {
				Gok.setVisible(false);
				Fgive.setVisible(false);
			}
		}
	}

	public class miniwindowEvent extends WindowAdapter implements MouseListener, MouseWheelListener {

		public void windowClosing(WindowEvent we) {
			Fminiwindow.setVisible(false);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Fminiwindow.setSize(180, 300);
			Fminiwindow.setLocation(1350, 520);
			String id[] = Body.getTitle().split("��");
			Loginlist = dao.Search_login_list(id[0]);
			Logininfo logdata = (Logininfo) Loginlist.get(0);
			if (logdata.getLogoffnow() == 1) {
				DduplicateLogoff.setVisible(true);
			} else if (logdata.getLogoffnow() == 2) {
				shareslist = sharesDao.interest_MAX_cnt(id[0]);
				sharesVo data = new sharesVo();
				data = (sharesVo) shareslist.get(0);
				sharesDao.Load_user_interest_list(id[0], data.getCnt());
				String userInteresteddata[] = data.getInterest_user_shares();
				for (int i = 0; i < data.getCnt(); i++) {
					System.out.println(userInteresteddata[i]);
					MiniName[i].setText(userInteresteddata[i]);
					MiniName[i].setForeground(Color.black);
					try {
						Urlreader reader = new Urlreader(MiniName[i].getText());
						MiniNowprice[i].setText(reader.getPrice());
						if (reader.getYday().equals("���")) {
							MiniNowprice[i].setForeground(Color.red);
						} else if (reader.getYday().equals("����")) {
							MiniNowprice[i].setForeground(Color.black);
						} else {
							MiniNowprice[i].setForeground(Color.blue);
						}
					} catch (IOException e1) {
						e1.printStackTrace();

					} catch (NumberFormatException e2) {
						e2.printStackTrace();
					}
				}
				shareslist = sharesDao.interest_MAX_cnt(id[0]);
				sharesVo newdata = new sharesVo();
				newdata = (sharesVo) shareslist.get(0);
				for (int i = newdata.getCnt(); i < 10; i++) {
					MiniName[i].setText("");
					MiniNowprice[i].setText("");
				}
			} else {
				System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {
				MiniName[i].setForeground(Color.white);
				MiniNowprice[i].setForeground(Color.white);
			}
		}
	}

	public class logoutEvent extends WindowAdapter implements ActionListener, KeyListener {
		public void windowClosing(WindowEvent we) {
			LogoutDyesorno.setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�α׾ƿ�")) {
				LogoutDyesorno.setVisible(true);
			}
			if (e.getActionCommand().equals("��")) {
				LogoutDyesorno.setVisible(false);
				LogoutDok.setVisible(true);
			}
			if (e.getActionCommand().equals("�ƴϿ�")) {
				LogoutDyesorno.setVisible(false);
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == 10) {
				LogoutDyesorno.setVisible(false);
				LogoutDok.setVisible(true);
			}
			if (e.getKeyCode() == 27) {
				LogoutDyesorno.setVisible(false);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public class logoutEvent2 extends WindowAdapter implements ActionListener, KeyListener {

		public void windowClosing(WindowEvent we) {
			LogoutDok.setVisible(false);

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("���α׷� �����")) {
				Body.dispose();
				LogoutDok.setVisible(false);
				LogoutDok.setVisible(false);
				Loginlist = dao.Loginlist();
				Logininfo data2 = (Logininfo) Loginlist.get(0);
				String id = data2.getId();
				dao.Logout(id);

				new startFrame();
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == 10) {
				Body.dispose();
				LogoutDok.setVisible(false);
				Loginlist = dao.Loginlist();
				Logininfo data2 = (Logininfo) Loginlist.get(0);
				String id = data2.getId();
				dao.Logout(id);
				System.out.println("������");
				new startFrame();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public class popupEvent extends WindowAdapter implements ActionListener, KeyListener {

		public void windowClosing(WindowEvent we) {

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("���ΰ�ħ")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��");
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					String dShow = "";
					Urlreader showM = new Urlreader();
					try {
						dShow = showM.showMarket();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lbl3.setText(dShow);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������

					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
										InterestGoalstate[i].setText("");
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
										InterestGoalstate[i].setText("");
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
							IbMinus[i].setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NumberFormatException e2) {
							e2.printStackTrace();
						}
					}
					for (int i = data.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				}
			}
			if (e.getActionCommand().equals("��ǥ�� ����")) {
				Fgoal.setVisible(true);
				dao = new MemberDAO();
				String id1[] = Body.getTitle().split("��");// id[0]
				Loginlist = dao.Search_login_list(id1[0]);
				Logininfo logdata1 = (Logininfo) Loginlist.get(0);
				if (logdata1.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else {
					Fgoal.setVisible(true);
					GoalLclicked.setText("");
					Loginlist = dao.Loginlist();
					Logininfo Logindata = (Logininfo) Loginlist.get(0);
					String nowId = Logindata.getId();
					shareslist = sharesDao.interest_MAX_cnt(nowId);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(nowId, data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						GoalLinterestList[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(GoalLinterestList[i].getText());
							GoalLnowprice[i].setText(reader.getPrice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					shareslist = sharesDao.interest_MAX_cnt(Logindata.getId());
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						GoalLinterestList[i].setText("");
						GoalLnowprice[i].setText("");
					}
				}
				//

			}
			if (e.getActionCommand().equals("���ŵ� ��Ȳ")) {
				dao = new MemberDAO();
				String id1[] = Body.getTitle().split("��");// id[0]
				Loginlist = dao.Search_login_list(id1[0]);
				Logininfo logdata1 = (Logininfo) Loginlist.get(0);
				if (logdata1.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else {
					Urlreader url = new Urlreader();
					if (Ftfsearch2.getText().equals("")) {
					} else {
						shareslist = sharesDao.select_shares_info(Ftfsearch2.getText().toUpperCase());
						sharesVo data = new sharesVo();
						data = (sharesVo) shareslist.get(0);
						String code = data.getCode();
						url.StartSHORTUrl(code);
					}
				}
			}
			if (e.getActionCommand().equals("������й�")) {
				dao = new MemberDAO();
				String id1[] = Body.getTitle().split("��");// id[0]
				Loginlist = dao.Search_login_list(id1[0]);
				Logininfo logdata1 = (Logininfo) Loginlist.get(0);
				if (logdata1.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else {
					Urlreader url = new Urlreader();
					if (Ftfsearch2.getText() == "") {
					}
					if (Ftfsearch2.getText() != "") {
						shareslist = sharesDao.select_shares_info(Ftfsearch2.getText().toUpperCase());
						sharesVo data = new sharesVo();
						data = (sharesVo) shareslist.get(0);
						String code = data.getCode();
						url.StartDISCUSSUrl(code);
					}

				}

			}
			if (e.getActionCommand().equals("��Ʈ���� ����")) {
				dao = new MemberDAO();
				String id1[] = Body.getTitle().split("��");// id[0]
				Loginlist = dao.Search_login_list(id1[0]);
				Logininfo logdata1 = (Logininfo) Loginlist.get(0);
				if (logdata1.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else {
					Urlreader url = new Urlreader();
					if (Ftfsearch2.getText().equals("")) {
					} else {
						shareslist = sharesDao.select_shares_info(Ftfsearch2.getText());
						sharesVo data = new sharesVo();
						data = (sharesVo) shareslist.get(0);
						String code = data.getCode();
						url.StartDARTUrl(code);
					}
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
//			if (e.getKeyCode() == 10) {
//				
//			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public class GoalEvent extends WindowAdapter implements ActionListener {
		public void windowClosing(WindowEvent we) {
			Fgoal.setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�����ϱ�")) {
				if (GoalCBupper.getState()) {
					sharesDao.set_user_target_price(GoalLclicked.getText(), 1, Goaltfupper.getText());
					GoalDok.setVisible(true);
				} else if (GoalCBdowner.getState()) {
					sharesDao.set_user_target_price(GoalLclicked.getText(), 2, Goaltfdowner.getText());
					GoalDok.setVisible(true);
				} else if (GoalCBdelete.getState()) {
					sharesDao.delete_user_target_price(GoalLclicked.getText());
					GoalDok.setVisible(true);
				}
			}
			if (e.getActionCommand().equals("���ư���")) {
				Fgoal.setVisible(false);
			}
			if (e.getActionCommand().equals("Ȯ��")) {
				String id[] = Body.getTitle().split("��");
				GoalDok.setVisible(false);
				shareslist = sharesDao.interest_MAX_cnt(id[0]);
				sharesVo data = new sharesVo();
				data = (sharesVo) shareslist.get(0);
				sharesDao.Load_user_interest_list(id[0], data.getCnt());
				String userInteresteddata[] = data.getInterest_user_shares();
				int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
				int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
				for (int i = 0; i < data.getCnt(); i++) {
					System.out.println(userInteresteddata[i]);
					InterName[i].setText(userInteresteddata[i]);
					try {
						Urlreader reader = new Urlreader(InterName[i].getText());
						int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
						InterNowprice[i].setText(reader.getPrice());
						if (reader.getYday().equals("���")) {
							Interupdown[i].setForeground(Color.red);
							Interupdown[i].setText("��");
						} else if (reader.getYday().equals("����")) {
							Interupdown[i].setText("-");
						} else {
							Interupdown[i].setForeground(Color.blue);
							Interupdown[i].setText("��");
						}
						if (targetupdown[i] != 0) {
							if (targetupdown[i] == 1) {
								if (numberprice >= targetPrice[i]) {
									InterestGoalstate[i].setText("�ݡ�");
									InterestGoalstate[i].setForeground(Color.red);
								} else {
									InterestGoalstate[i].setText("");
								}
							} else if (targetupdown[i] == 2) {
								if (targetPrice[i] >= numberprice) {
									InterestGoalstate[i].setText("�ݡ�");
									InterestGoalstate[i].setForeground(Color.blue);
								} else {
									InterestGoalstate[i].setText("");
								}
							}

						} else {
							System.out.println("�ΰ���");
							InterestGoalstate[i].setText("");
						}

						Interdiffprice[i].setText(reader.getYprice());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					IbMinus[i].setVisible(true);
				}
				shareslist = sharesDao.interest_MAX_cnt(id[0]);
				sharesVo newdata = new sharesVo();
				newdata = (sharesVo) shareslist.get(0);
				for (int i = newdata.getCnt(); i < 10; i++) {
					InterName[i].setText("");
					InterNowprice[i].setText("");
					Interupdown[i].setText("");
					Interdiffprice[i].setText("");
					InterestGoalstate[i].setText("");
					IbMinus[i].setVisible(false);
				}
			}
		}
	}

	public class GoalDialogExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			GoalDok.setVisible(false);
		}
	}

	public class MdpwdExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			Mdpwd.setVisible(false);
		}
	}

	public class MdokExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			Fmodify.setVisible(true);
			Mdok.setVisible(false);
		}
	}

	public class DuplicateLogout extends WindowAdapter implements ActionListener, KeyListener {
		public void windowClosing(WindowEvent we) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("���α׷� ����")) {
				DduplicateLogoff.setVisible(false);
				System.exit(0);
				new startFrame();
			}
		}

	}

	public class giveEvent extends WindowAdapter implements ActionListener, KeyListener {
		public void windowClosing(WindowEvent we) {
			Gok.setVisible(false);
			Fgive.setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("�����ϱ�")) {// �ǰ�
				int survey = s1 + s2 + s3 + s4;
				Loginlist = dao.Loginlist();
				Logininfo data = (Logininfo) Loginlist.get(0);
				String nowId = data.getId();
				dao.SaveSuggestionDater(nowId, Gtfreason.getText(), survey);
				Gok.setVisible(true);
				if (e.getActionCommand().equals("���ư���")) {
					Gok.setVisible(false);
					Fgive.setVisible(false);
				}
			}
			if (e.getActionCommand().equals("���ư���")) {
				Gok.setVisible(false);
				Fgive.setVisible(false);
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			Gok.setVisible(false);
			Fgive.setVisible(false);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public class otherExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			Fother.setVisible(false);
		}
	}

	public class exitExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			Dexit.setVisible(false);
		}
	}

	public class withEvent extends WindowAdapter implements ActionListener {
		public void windowClosing(WindowEvent we) {
			Fwith.setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("�����ϱ�")) {// Ż��� �ǰ�
				int survey = s1 + s2 + s3 + s4;
				dao.SaveSuggestionDater("", Wtfreason.getText(), survey);
				WsDok.setVisible(true);
			}
			if (e.getSource().equals("���α׷� ����") || e.getActionCommand().equals("���α׷� ����")) {
				dao = new MemberDAO();
				String id1[] = Body.getTitle().split("��");// id[0]
				Loginlist = dao.Search_login_list(id1[0]);
				Logininfo logdata1 = (Logininfo) Loginlist.get(0);
				if (logdata1.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				}
				WsDok.setVisible(false);
				Fwith.setVisible(false);
				Fmodify.setVisible(false);

				Body.dispose();
				dao = new MemberDAO();
				Loginlist = dao.Loginlist();
				Logininfo data2 = (Logininfo) Loginlist.get(0);
				String id = data2.getId();
				dao.Logout(id);
//				dao.withrawalUser_deletedata(id);
				dao.withrawalUser(id);

				new startFrame();
			}

		}
	}

	public class issueExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			Fissue.setVisible(false);
		}
	}

	public class modifyEvent extends WindowAdapter implements ActionListener {
		public void windowClosing(WindowEvent we) {
			Fmodify.setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("ȸ������ ����")) {
				dao = new MemberDAO();
				String id1[] = Body.getTitle().split("��");// id[0]
				Loginlist = dao.Search_login_list(id1[0]);
				Logininfo logdata1 = (Logininfo) Loginlist.get(0);
				if (logdata1.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				}
				Mdpwd.setVisible(true);
			}
			if (e.getActionCommand().equals("Ȯ��") || e.getSource() == Mtfpwd) {
				Loginlist = dao.Loginlist();
				Logininfo data = (Logininfo) Loginlist.get(0);
				String nowPassword = data.getPassword();
				String nowEmail = data.getEmail();
				if (nowPassword.equals(Mtfpwd.getText())) {
					Fmodify.setVisible(true);
					Mdpwd.setVisible(false);
					Mtfpwd.setText("");
					modtfemail.setText(nowEmail);
				} else {
				}
			}
			if (e.getActionCommand().equals("�����ϱ�")) {
				dao.modificationInfo(modtfid.getText(), modtfpw.getText(), modtfemail.getText());
				Fmodify.setVisible(false);
				Mdok.setVisible(true);
			}
			if (e.getActionCommand().equals("ȸ��Ż��")) {
				Fwith.setVisible(true);
			}
			if (e.getActionCommand().equals("���ư���")) {
				Fmodify.setVisible(false);
			}
			if (e.getActionCommand().equals("�Ϸ�")) {
				Mdok.setVisible(false);
				Fmodify.setVisible(true);
			}
		}
	}

	public class AddEvent implements KeyListener, ActionListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			Iadd.setVisible(false);
			dao = new MemberDAO();
			String id1[] = Body.getTitle().split("��");// id[0]
			Loginlist = dao.Search_login_list(id1[0]);
			Logininfo logdata1 = (Logininfo) Loginlist.get(0);
			if (logdata1.getLogoffnow() == 1) {
				System.out.println("�����α׿����Ȱ��");
				DduplicateLogoff.setVisible(true);
			}
			shareslist = sharesDao.interest_MAX_cnt(id1[0]);
			sharesVo data = new sharesVo();
			data = (sharesVo) shareslist.get(0);
			int cnt = data.getCnt();
			int MAX_ADD_CNT = 10;
			Loginlist = dao.Loginlist();
			//// �ִ� ���� 10�� �����ϰ� �װ� �ʰ��ϸ� �����޼����߻��ϵ��� ����
			if (cnt < MAX_ADD_CNT) {
				if (!Ftfsearch2.getText().equals("")) {
					sharesDao.select_shares_info(Ftfsearch2.getText().toUpperCase());
					sharesDao.insert_interest(id1[0], Ftfsearch2.getText().toUpperCase());
					System.out.println(cnt);
				} else {
					System.out.println("�Է����ּ���.");
				}
			} else {
				System.out.println("�ִ밳�� 10�� �ʰ�");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Ȯ��")) {
				Iadd.setVisible(false);
				String id[] = Body.getTitle().split("��");
				shareslist = sharesDao.interest_MAX_cnt(id[0]);
				sharesVo data = new sharesVo();
				data = (sharesVo) shareslist.get(0);
				int cnt = data.getCnt();
				int MAX_ADD_CNT = 10;
				Loginlist = dao.Loginlist();
				//// �ִ� ���� 10�� �����ϰ� �װ� �ʰ��ϸ� �����޼����߻��ϵ��� ����
				if (cnt < MAX_ADD_CNT) {
					if (!Ftfsearch2.getText().equals("")) {
						sharesDao.select_shares_info(Ftfsearch2.getText().toUpperCase());
						sharesDao.insert_interest(id[0], Ftfsearch2.getText().toUpperCase());
						System.out.println(cnt);
					} else {
						System.out.println("�Է����ּ���.");
					}
				} else {
					System.out.println("�ִ밳�� 10�� �ʰ�");
				}
			}
			if (e.getActionCommand().equals("F5")) {
				String id[] = Body.getTitle().split("��");
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
							IbMinus[i].setVisible(true);
						} catch (IOException e1) {
							e1.printStackTrace();

						} catch (NumberFormatException e2) {
							e2.printStackTrace();
						}
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-1")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[0].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-2")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[1].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-3")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[2].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-4")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[3].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-5")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[4].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-6")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[5].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-7")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[6].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-8")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[7].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-9")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[8].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("-10")) {
				dao = new MemberDAO();
				String id[] = Body.getTitle().split("��"); // id[0]
				Loginlist = dao.Search_login_list(id[0]);
				Logininfo logdata = (Logininfo) Loginlist.get(0);
				if (logdata.getLogoffnow() == 1) {
					System.out.println("�����α׿����Ȱ��");
					DduplicateLogoff.setVisible(true);
				} else if (logdata.getLogoffnow() == 2) {
					sharesDao.delete_user_interest_list(InterName[9].getText(), id[0]);
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo data = new sharesVo();
					data = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(id[0], data.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					int targetPrice[] = data.getTarget_price();//// 1���� 0���� ������
					int targetupdown[] = data.getTarget_updown();//// 1���� 0���� ������
					for (int i = 0; i < data.getCnt(); i++) {
						System.out.println(userInteresteddata[i]);
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							int numberprice = (Integer.parseInt(reader.getPrice().replace(",", "")));
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							if (targetupdown[i] != 0) {
								if (targetupdown[i] == 1) {
									if (numberprice >= targetPrice[i]) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.red);
									} else {
									}
								} else if (targetupdown[i] == 2) {
									if (targetPrice[i] >= numberprice) {
										InterestGoalstate[i].setText("�ݡ�");
										InterestGoalstate[i].setForeground(Color.blue);
									} else {
									}
								}

							} else {
								System.out.println("�ΰ���");
								InterestGoalstate[i].setText("");
							}
							Interdiffprice[i].setText(reader.getYprice());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						IbMinus[i].setVisible(true);
					}
					shareslist = sharesDao.interest_MAX_cnt(id[0]);
					sharesVo newdata = new sharesVo();
					newdata = (sharesVo) shareslist.get(0);
					for (int i = newdata.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						InterestGoalstate[i].setText("");
						IbMinus[i].setVisible(false);
					}
				} else {
					System.out.println("�� ��û�� ���ܹ߻� : " + logdata.getLogoffnow());
				}

			}
			if (e.getActionCommand().equals("���������߰�")) {
				String nowId[] = Body.getTitle().split("��");
				shareslist = sharesDao.interest_MAX_cnt(nowId[0]);
				sharesVo data = new sharesVo();
				data = (sharesVo) shareslist.get(0);
				int cnt = data.getCnt();
				int MAX_ADD_CNT = 10;
				boolean check = false;
				Loginlist = dao.Loginlist();
				//// �ִ� ���� 10�� �����ϰ� �װ� �ʰ��ϸ� �����޼����߻��ϵ��� ����
				if (cnt < MAX_ADD_CNT) {
					if (!LsearchSetting.getText().equals("")) {
						Iadd.setVisible(true);
						check = true;
						sharesDao.select_shares_info(LsearchSetting.getText().toUpperCase());
						sharesDao.insert_interest(nowId[0], LsearchSetting.getText().toUpperCase());
						System.out.println(cnt);
					} else {
						System.out.println("�Է����ּ���.");
					}
				} else {
					DInterWarning.setVisible(true);
					System.out.println("�ִ밳�� 10�� �ʰ�");
				}
				// ���ΰ�ħ�Ǵºκ�
				if (check) {
					sharesVo newdata = new sharesVo();
					shareslist = sharesDao.interest_MAX_cnt(nowId[0]);
					newdata = (sharesVo) shareslist.get(0);
					sharesDao.Load_user_interest_list(nowId[0], newdata.getCnt());
					String userInteresteddata[] = data.getInterest_user_shares();
					for (int i = 0; i < newdata.getCnt(); i++) {
						InterName[i].setText(userInteresteddata[i]);
						try {
							Urlreader reader = new Urlreader(InterName[i].getText());
							InterNowprice[i].setText(reader.getPrice());
							if (reader.getYday().equals("���")) {
								Interupdown[i].setForeground(Color.red);
								Interupdown[i].setText("��");
							} else if (reader.getYday().equals("����")) {
								Interupdown[i].setForeground(Color.gray);
								Interupdown[i].setText("-");
							} else {
								Interupdown[i].setForeground(Color.blue);
								Interupdown[i].setText("��");
							}
							Interdiffprice[i].setText(reader.getYprice());
							IbMinus[i].setVisible(true);

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					shareslist = sharesDao.interest_MAX_cnt(nowId[0]);
					sharesVo newdata2 = new sharesVo();
					newdata2 = (sharesVo) shareslist.get(0);
					for (int i = newdata2.getCnt(); i < 10; i++) {
						InterName[i].setText("");
						InterNowprice[i].setText("");
						Interupdown[i].setText("");
						Interdiffprice[i].setText("");
						IbMinus[i].setVisible(false);
					}
				}
				// ���ΰ�ħ
			}
		}

	}

//////////// ���� ���⼭ ��ư �ϳ��ϳ� ������ ���̾�α�
	public class DBwarningOk implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("Ȯ��")) {
				DInterWarning.setVisible(false);
			}
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Date date = new Date();
			DateFormat dDate = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
			DateFormat dTime = DateFormat.getTimeInstance(DateFormat.FULL, Locale.US);
			DateFormat drealTime = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.US);
			lbl1.setText(dDate.format(date));
			lbl2.setText(dTime.format(date));
			Minitime.setText(drealTime.format(date));
			try {
				Thread.sleep(1000);// 1�� ������ ���� �ð��� ���ŵȴ�.
			} catch (InterruptedException e) {

			}
		}

	}

	public class SimpleKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_F5) {
				System.out.println("refresh");
				String dShow = "";
				Urlreader showM = new Urlreader();
				try {
					dShow = showM.showMarket();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lbl3.setText(dShow);
			}
		}

	}

	public class maechulClickEvent implements MouseListener {
		boolean LmaechulS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LmaechulS) { // �����׿� �ƹ��͵�������
					this.LmaechulS = true;
					for (int i = 0; i < 10; i++) {
						Lmaechulnum[i].setBackground(Color.yellow);
					}

				} else {
					this.LmaechulS = false;
					for (int i = 0; i < 10; i++) {
						Lmaechulnum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LmaechulS) { // �����׿� �ƹ��͵�������
					this.LmaechulS = true;
					for (int i = 0; i < 10; i++) {
						Lmaechulnum[i].setBackground(Color.gray);
					}

				} else {
					this.LmaechulS = false;
					for (int i = 0; i < 10; i++) {
						Lmaechulnum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lmaechul.setFont(Fonttable3);
			Lmaechul.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lmaechul.setFont(Fonttable1);
			if (darkmode == 0) {
				Lmaechul.setForeground(Color.black);
			} else {
				Lmaechul.setForeground(Color.white);
			}

		}
	}

	public class younupClickEvent implements MouseListener {
		boolean LyounupS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LyounupS) { // �����׿� �ƹ��͵�������
					this.LyounupS = true;
					for (int i = 0; i < 10; i++) {
						Lyounupnum[i].setBackground(Color.yellow);
					}

				} else {
					this.LyounupS = false;
					for (int i = 0; i < 10; i++) {
						Lyounupnum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LyounupS) { // �����׿� �ƹ��͵�������
					this.LyounupS = true;
					for (int i = 0; i < 10; i++) {
						Lyounupnum[i].setBackground(Color.gray);
					}

				} else {
					this.LyounupS = false;
					for (int i = 0; i < 10; i++) {
						Lyounupnum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lyounup.setFont(Fonttable3);
			Lyounup.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lyounup.setFont(Fonttable1);
			if (darkmode == 0) {
				Lyounup.setForeground(Color.black);
			} else {
				Lyounup.setForeground(Color.white);
			}

		}
	}

	public class dangiClickEvent implements MouseListener {
		boolean LdangiS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LdangiS) { // �����׿� �ƹ��͵�������
					this.LdangiS = true;
					for (int i = 0; i < 10; i++) {
						Ldanginum[i].setBackground(Color.yellow);
					}

				} else {
					this.LdangiS = false;
					for (int i = 0; i < 10; i++) {
						Ldanginum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LdangiS) { // �����׿� �ƹ��͵�������
					this.LdangiS = true;
					for (int i = 0; i < 10; i++) {
						Ldanginum[i].setBackground(Color.gray);
					}

				} else {
					this.LdangiS = false;
					for (int i = 0; i < 10; i++) {
						Ldanginum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldangi.setFont(Fonttable3);
			Ldangi.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldangi.setFont(Fonttable1);
			if (darkmode == 0) {
				Ldangi.setForeground(Color.black);
			} else {
				Ldangi.setForeground(Color.white);
			}

		}
	}

	public class youngupperClickEvent implements MouseListener {
		boolean LyoungupperS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LyoungupperS) { // �����׿� �ƹ��͵�������
					this.LyoungupperS = true;
					for (int i = 0; i < 10; i++) {
						Lyounguppernum[i].setBackground(Color.yellow);
					}

				} else {
					this.LyoungupperS = false;
					for (int i = 0; i < 10; i++) {
						Lyounguppernum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LyoungupperS) { // �����׿� �ƹ��͵�������
					this.LyoungupperS = true;
					for (int i = 0; i < 10; i++) {
						Lyounguppernum[i].setBackground(Color.gray);
					}

				} else {
					this.LyoungupperS = false;
					for (int i = 0; i < 10; i++) {
						Lyounguppernum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lyoungupper.setFont(Fonttable3);
			Lyoungupper.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lyoungupper.setFont(Fonttable1);
			if (darkmode == 0) {
				Lyoungupper.setForeground(Color.black);
			} else {
				Lyoungupper.setForeground(Color.white);
			}

		}
	}

	public class soonClickEvent implements MouseListener {
		boolean LsoonS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LsoonS) { // �����׿� �ƹ��͵�������
					this.LsoonS = true;
					for (int i = 0; i < 10; i++) {
						Lsoonnum[i].setBackground(Color.yellow);
					}

				} else {
					this.LsoonS = false;
					for (int i = 0; i < 10; i++) {
						Lsoonnum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LsoonS) { // �����׿� �ƹ��͵�������
					this.LsoonS = true;
					for (int i = 0; i < 10; i++) {
						Lsoonnum[i].setBackground(Color.gray);
					}

				} else {
					this.LsoonS = false;
					for (int i = 0; i < 10; i++) {
						Lsoonnum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lsoon.setFont(Fonttable3);
			Lsoon.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lsoon.setFont(Fonttable1);
			if (darkmode == 0) {
				Lsoon.setForeground(Color.black);
			} else {
				Lsoon.setForeground(Color.white);
			}

		}
	}

	public class buchaeClickEvent implements MouseListener {
		boolean LbuchaeS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LbuchaeS) { // �����׿� �ƹ��͵�������
					this.LbuchaeS = true;
					for (int i = 0; i < 10; i++) {
						Lbuchaenum[i].setBackground(Color.yellow);
					}

				} else {
					this.LbuchaeS = false;
					for (int i = 0; i < 10; i++) {
						Lbuchaenum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LbuchaeS) { // �����׿� �ƹ��͵�������
					this.LbuchaeS = true;
					for (int i = 0; i < 10; i++) {
						Lbuchaenum[i].setBackground(Color.gray);
					}

				} else {
					this.LbuchaeS = false;
					for (int i = 0; i < 10; i++) {
						Lbuchaenum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lbuchae.setFont(Fonttable3);
			Lbuchae.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lbuchae.setFont(Fonttable1);
			if (darkmode == 0) {
				Lbuchae.setForeground(Color.black);
			} else {
				Lbuchae.setForeground(Color.white);
			}

		}
	}

	public class dangjwaClickEvent implements MouseListener {
		boolean LdangjwaS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LdangjwaS) { // �����׿� �ƹ��͵�������
					this.LdangjwaS = true;
					for (int i = 0; i < 10; i++) {
						Ldangjwanum[i].setBackground(Color.yellow);
					}

				} else {
					this.LdangjwaS = false;
					for (int i = 0; i < 10; i++) {
						Ldangjwanum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LdangjwaS) { // �����׿� �ƹ��͵�������
					this.LdangjwaS = true;
					for (int i = 0; i < 10; i++) {
						Ldangjwanum[i].setBackground(Color.gray);
					}

				} else {
					this.LdangjwaS = false;
					for (int i = 0; i < 10; i++) {
						Ldangjwanum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldangjwa.setFont(Fonttable3);
			Ldangjwa.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldangjwa.setFont(Fonttable1);
			if (darkmode == 0) {
				Ldangjwa.setForeground(Color.black);
			} else {
				Ldangjwa.setForeground(Color.white);
			}

		}
	}

	public class yuboClickEvent implements MouseListener {
		boolean LyuboS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LyuboS) { // �����׿� �ƹ��͵�������
					this.LyuboS = true;
					for (int i = 0; i < 10; i++) {
						Lyubonum[i].setBackground(Color.yellow);
					}

				} else {
					this.LyuboS = false;
					for (int i = 0; i < 10; i++) {
						Lyubonum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LyuboS) { // �����׿� �ƹ��͵�������
					this.LyuboS = true;
					for (int i = 0; i < 10; i++) {
						Lyubonum[i].setBackground(Color.gray);
					}

				} else {
					this.LyuboS = false;
					for (int i = 0; i < 10; i++) {
						Lyubonum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lyubo.setFont(Fonttable3);
			Lyubo.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lyubo.setFont(Fonttable1);
			if (darkmode == 0) {
				Lyubo.setForeground(Color.black);
			} else {
				Lyubo.setForeground(Color.white);
			}

		}
	}

	public class epsClickEvent implements MouseListener {
		boolean LepsS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LepsS) { // �����׿� �ƹ��͵�������
					this.LepsS = true;
					for (int i = 0; i < 10; i++) {
						Lepsnum[i].setBackground(Color.yellow);
					}

				} else {
					this.LepsS = false;
					for (int i = 0; i < 10; i++) {
						Lepsnum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LepsS) { // �����׿� �ƹ��͵�������
					this.LepsS = true;
					for (int i = 0; i < 10; i++) {
						Lepsnum[i].setBackground(Color.gray);
					}

				} else {
					this.LepsS = false;
					for (int i = 0; i < 10; i++) {
						Lepsnum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Leps.setFont(Fonttable3);
			Leps.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Leps.setFont(Fonttable1);
			if (darkmode == 0) {
				Leps.setForeground(Color.black);
			} else {
				Leps.setForeground(Color.white);
			}

		}
	}

	public class perClickEvent implements MouseListener {
		boolean LperS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LperS) { // �����׿� �ƹ��͵�������
					this.LperS = true;
					for (int i = 0; i < 10; i++) {
						Lpernum[i].setBackground(Color.yellow);
					}

				} else {
					this.LperS = false;
					for (int i = 0; i < 10; i++) {
						Lpernum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LperS) { // �����׿� �ƹ��͵�������
					this.LperS = true;
					for (int i = 0; i < 10; i++) {
						Lpernum[i].setBackground(Color.gray);
					}

				} else {
					this.LperS = false;
					for (int i = 0; i < 10; i++) {
						Lpernum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lper.setFont(Fonttable3);
			Lper.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lper.setFont(Fonttable1);
			if (darkmode == 0) {
				Lper.setForeground(Color.black);
			} else {
				Lper.setForeground(Color.white);
			}

		}
	}

	public class bpsClickEvent implements MouseListener {
		boolean LbpsS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LbpsS) { // �����׿� �ƹ��͵�������
					this.LbpsS = true;
					for (int i = 0; i < 10; i++) {
						Lbpsnum[i].setBackground(Color.yellow);
					}

				} else {
					this.LbpsS = false;
					for (int i = 0; i < 10; i++) {
						Lbpsnum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LbpsS) { // �����׿� �ƹ��͵�������
					this.LbpsS = true;
					for (int i = 0; i < 10; i++) {
						Lbpsnum[i].setBackground(Color.gray);
					}

				} else {
					this.LbpsS = false;
					for (int i = 0; i < 10; i++) {
						Lbpsnum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lbps.setFont(Fonttable3);
			Lbps.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lbps.setFont(Fonttable1);
			if (darkmode == 0) {
				Lbps.setForeground(Color.black);
			} else {
				Lbps.setForeground(Color.white);
			}

		}
	}

	public class pbrClickEvent implements MouseListener {
		boolean LpbrS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LpbrS) { // �����׿� �ƹ��͵�������
					this.LpbrS = true;
					for (int i = 0; i < 10; i++) {
						Lpbrnum[i].setBackground(Color.yellow);
					}

				} else {
					this.LpbrS = false;
					for (int i = 0; i < 10; i++) {
						Lpbrnum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LpbrS) { // �����׿� �ƹ��͵�������
					this.LpbrS = true;
					for (int i = 0; i < 10; i++) {
						Lpbrnum[i].setBackground(Color.gray);
					}

				} else {
					this.LpbrS = false;
					for (int i = 0; i < 10; i++) {
						Lpbrnum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Lpbr.setFont(Fonttable3);
			Lpbr.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Lpbr.setFont(Fonttable1);
			if (darkmode == 0) {
				Lpbr.setForeground(Color.black);
			} else {
				Lpbr.setForeground(Color.white);
			}

		}
	}

	public class divwonClickEvent implements MouseListener {
		boolean LdivwonS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LdivwonS) { // �����׿� �ƹ��͵�������
					this.LdivwonS = true;
					for (int i = 0; i < 4; i++) {
						Ldivwonnum[i].setBackground(Color.yellow);
					}

				} else {
					this.LdivwonS = false;
					for (int i = 0; i < 4; i++) {
						Ldivwonnum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LdivwonS) { // �����׿� �ƹ��͵�������
					this.LdivwonS = true;
					for (int i = 0; i < 4; i++) {
						Ldivwonnum[i].setBackground(Color.gray);
					}

				} else {
					this.LdivwonS = false;
					for (int i = 0; i < 4; i++) {
						Ldivwonnum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldivwon.setFont(Fonttable3);
			Ldivwon.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldivwon.setFont(Fonttable1);
			if (darkmode == 0) {
				Ldivwon.setForeground(Color.black);
			} else {
				Ldivwon.setForeground(Color.white);
			}

		}
	}

	public class divperClickEvent implements MouseListener {
		boolean LdivperS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LdivperS) { // �����׿� �ƹ��͵�������
					this.LdivperS = true;
					for (int i = 0; i < 4; i++) {
						Ldivpernum[i].setBackground(Color.yellow);
					}

				} else {
					this.LdivperS = false;
					for (int i = 0; i < 4; i++) {
						Ldivpernum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LdivperS) { // �����׿� �ƹ��͵�������
					this.LdivperS = true;
					for (int i = 0; i < 4; i++) {
						Ldivpernum[i].setBackground(Color.darkGray);
					}

				} else {
					this.LdivperS = false;
					for (int i = 0; i < 4; i++) {
						Ldivpernum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldivper.setFont(Fonttable3);
			Ldivper.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ldivper.setFont(Fonttable1);
			if (darkmode == 0) {
				Ldivper.setForeground(Color.black);
			} else {
				Ldivper.setForeground(Color.white);
			}

		}
	}

	public class jibaeClickEvent implements MouseListener {
		boolean LjibaeS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (darkmode == 0) {
				if (!LjibaeS) { // �����׿� �ƹ��͵�������
					this.LjibaeS = true;
					for (int i = 0; i < 10; i++) {
						Ljibaenum[i].setBackground(Color.yellow);
					}

				} else {
					this.LjibaeS = false;
					for (int i = 0; i < 10; i++) {
						Ljibaenum[i].setBackground(Color.white);
					}
				}
			}
			if (darkmode == 1) {
				if (!LjibaeS) { // �����׿� �ƹ��͵�������
					this.LjibaeS = true;
					for (int i = 0; i < 10; i++) {
						Ljibaenum[i].setBackground(Color.gray);
					}

				} else {
					this.LjibaeS = false;
					for (int i = 0; i < 10; i++) {
						Ljibaenum[i].setBackground(Color.black);
					}
				}
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable3);
			Ljibae.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				Ljibae.setForeground(Color.black);
			} else {
				Ljibae.setForeground(Color.white);
			}

		}
	}

	public class GoalListinterestListEvent1 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			GoalLclicked.setText(GoalLinterestList[0].getText());
			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[0].setFont(GoalFont3);
			GoalLinterestList[0].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[0].setFont(GoalFont2);
				GoalLinterestList[0].setForeground(Color.black);
			} else {
				GoalLinterestList[0].setForeground(Color.white);
			}

		}
	}

	public class GoalListinterestListEvent2 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			GoalLclicked.setText(GoalLinterestList[1].getText());
			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[1].setFont(GoalFont3);
			GoalLinterestList[1].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[1].setFont(GoalFont2);
				GoalLinterestList[1].setForeground(Color.black);
			} else {
				GoalLinterestList[1].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent3 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			GoalLclicked.setText(GoalLinterestList[2].getText());
			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[2].setFont(GoalFont3);
			GoalLinterestList[2].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[2].setFont(GoalFont2);
				GoalLinterestList[2].setForeground(Color.black);
			} else {
				GoalLinterestList[2].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent4 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLclicked.setText(GoalLinterestList[3].getText());
			GoalLclicked.setBackground(Color.yellow);

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[3].setFont(GoalFont3);
			GoalLinterestList[3].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[3].setFont(GoalFont2);
				GoalLinterestList[3].setForeground(Color.black);
			} else {
				GoalLinterestList[3].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent5 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			GoalLclicked.setText(GoalLinterestList[4].getText());
			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[4].setFont(GoalFont3);
			GoalLinterestList[4].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[4].setFont(GoalFont2);
				GoalLinterestList[4].setForeground(Color.black);
			} else {
				GoalLinterestList[4].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent6 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			GoalLclicked.setBackground(Color.yellow);
			GoalLclicked.setText(GoalLinterestList[5].getText());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[5].setFont(GoalFont3);
			GoalLinterestList[5].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[5].setFont(GoalFont2);
				GoalLinterestList[5].setForeground(Color.black);
			} else {
				GoalLinterestList[5].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent7 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			GoalLclicked.setText(GoalLinterestList[6].getText());
			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[6].setFont(GoalFont3);
			GoalLinterestList[6].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[6].setFont(GoalFont2);
				GoalLinterestList[6].setForeground(Color.black);
			} else {
				GoalLinterestList[6].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent8 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLclicked.setText(GoalLinterestList[7].getText());

			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[7].setFont(GoalFont3);
			GoalLinterestList[7].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[7].setFont(GoalFont2);
				GoalLinterestList[7].setForeground(Color.black);
			} else {
				GoalLinterestList[7].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent9 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLclicked.setText(GoalLinterestList[8].getText());
			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[8].setFont(GoalFont3);
			GoalLinterestList[8].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[8].setFont(GoalFont2);
				GoalLinterestList[8].setForeground(Color.black);
			} else {
				GoalLinterestList[8].setForeground(Color.white);
			}

		}

	}

	public class GoalListinterestListEvent10 implements MouseListener {
		boolean GoalListinterestListS = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLclicked.setText(GoalLinterestList[9].getText());
			GoalLclicked.setBackground(Color.yellow);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			GoalLinterestList[9].setFont(GoalFont3);
			GoalLinterestList[9].setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Ljibae.setFont(Fonttable1);
			if (darkmode == 0) {
				GoalLinterestList[9].setFont(GoalFont2);
				GoalLinterestList[9].setForeground(Color.black);
			} else {
				GoalLinterestList[9].setForeground(Color.white);
			}

		}

	}

}