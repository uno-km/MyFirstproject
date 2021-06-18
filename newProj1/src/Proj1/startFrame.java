package Proj1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class startFrame extends Source implements Runnable {

	startFrame() {
		Lbody = new Frame("로그인 화면");
		dao = new MemberDAO();
		sharesDao = new sharesDAO();

		//////////////////////// 랜덤격언 패널////

		/////////////////
		Font f = new Font("맑은 고딕", Font.BOLD, 16);
		int ran_num = (int) (Math.random() * 70) + 1;
		select_proverb = sharesDao.select_proverb(ran_num);
		sharesVo num = new sharesVo();
		num = (sharesVo) select_proverb.get(0);
		String prov = num.getProverb();
		llang = new Label(prov, Label.CENTER);
		llang.setLocation(0, 20);
		llang.setSize(500, 52);
		llang.setFont(f);
		llang.setForeground(Color.white);
		Plang = new Panel();
		Plang.setBackground(new Color(103, 119, 135));
		Plang.setLayout(null);
		Plang.add(llang);
		Plang.setSize(480, 100);
		Plang.setLocation(10, 50);
		/////////////////////////////////////////////
		////////////// 비밀번호 찾는 프레임///////////
		Ffind = new Frame("ID / 비밀번호 찾기");
		Ffind.setSize(450, 250);
		Ffind.setLayout(null);
		Ffind.setLocationRelativeTo(null);
		Ffind.addWindowListener(new FindIdPassword());

		findId = new Button("아이디 찾기");
		findId.setSize(100, 35);
		findId.setLocation(100, 40);

		findPwd = new Button("비밀번호 찾기");
		findPwd.setSize(100, 35);
		findPwd.setLocation(250, 40);

		PfindId = new Panel();
		PfindId.setLayout(null);
		PfindId.setBackground(Color.white);
		PfindId.setSize(450, 205);
		PfindId.setLocation(0, 100);
		PfindId.setVisible(true);

		findLidEmail = new Label("E-mail : ", Label.LEFT);
		findLidEmail.setBounds(20, 15, 60, 20);
		tfIdemail = new TextField();
		tfIdemail.setSize(200, 25);
		tfIdemail.setLocation(90, 15);
		tfIdemail.addActionListener(new FindIdPassword());

		findLidId = new Label("I   D : ", Label.LEFT);
		findLidId.setBounds(20, 50, 60, 20);
		tfIdid = new TextField();
		tfIdid.setSize(200, 25);
		tfIdid.setLocation(90, 50);
		tfIdid.setEditable(false);
		tfIdid.addActionListener(new FindIdPassword());

		tfIdm = new TextField("찾으실 ID의 E-mail을 입력해주세요.");
		tfIdm.setSize(200, 25);
		tfIdm.setLocation(90, 95);
		tfIdm.setEditable(false);
		tfIdm.addActionListener(new FindIdPassword());

		findBid = new Button("찾기");
		findBid.setSize(100, 35);
		findBid.setLocation(320, 25);
		findBid.addActionListener(new FindId());

		findBidBack = new Button("돌아가기");
		findBidBack.setSize(100, 35);
		findBidBack.setLocation(320, 70);
		findBidBack.addActionListener(new FindIdPassword());

		//////////////////////////////////////////////////////////
		PfindPwd = new Panel();
		PfindPwd.setBackground(Color.gray);
		PfindPwd.setSize(450, 205);
		PfindPwd.setLocation(0, 100);
		PfindPwd.setLayout(null);
		PfindPwd.setVisible(false);

		findLpwdId = new Label("I   D : ", Label.LEFT);
		findLpwdId.setBounds(20, 15, 60, 20);

		tfPwdid = new TextField("ID");
		tfPwdid.setSize(200, 25);
		tfPwdid.setLocation(90, 15);
		tfPwdid.addActionListener(new FindIdPassword());

		findLpwdEmail = new Label("E-mail : ", Label.LEFT);
		findLpwdEmail.setBounds(20, 50, 60, 20);
		tfPwdemail = new TextField();
		tfPwdemail.setSize(200, 25);
		tfPwdemail.setLocation(90, 50);
		tfPwdemail.addActionListener(new FindIdPassword());

		tfPwdm = new TextField("ID와 E-mail을 입력해주세요.");
		tfPwdm.setSize(200, 25);
		tfPwdm.setLocation(90, 95);
		tfPwdm.setEditable(false);
		tfPwdm.addActionListener(new FindIdPassword());

		findBpwd = new Button("찾기");
		findBpwd.setSize(100, 35);
		findBpwd.setLocation(320, 25);
		findBpwd.addActionListener(new FindIdPassword());

		findBpwdBack = new Button("돌아가기");
		findBpwdBack.setSize(100, 35);
		findBpwdBack.setLocation(320, 70);
		findBpwdBack.addActionListener(new FindIdPassword());

		Ffind.add(findId);
		Ffind.add(findPwd);
		Ffind.add(PfindId);
		Ffind.add(PfindPwd);
		PfindId.add(findLidEmail);
		PfindId.add(tfIdid);
		PfindId.add(tfIdemail);
		PfindId.add(tfIdm);
		PfindId.add(findLidId);
		PfindId.add(findBid);
		PfindId.add(findBidBack);

		PfindPwd.add(findLpwdEmail);
		PfindPwd.add(tfPwdid);
		PfindPwd.add(tfPwdemail);
		PfindPwd.add(tfPwdm);
		PfindPwd.add(findLpwdId);
		PfindPwd.add(findBpwd);
		PfindPwd.add(findBpwdBack);

		/////////////////////////////////////////////

		/////////////////////////////// 로그인 프레임
		lokD = new Dialog(Lbody, "로그인", true);
		lokD.setSize(200, 100);
		lokD.setLocation(50, 50);
		lokD.setLayout(new FlowLayout());

		Lbody.setSize(500, 300);
		Lbody.setLayout(null);
		Lbody.setLocationRelativeTo(null);

		login = new Button("로그인");
		login.setSize(100, 30);
		login.setLocation(330, 180);

		lid = new Label("I      D : ", Label.LEFT);
		lid.setBounds(20, 185, 60, 20);
		tfId = new TextField();
		tfId.setSize(200, 25);
		tfId.setLocation(90, 180);

		lpw = new Label("Password : ", Label.LEFT);
		lpw.setBounds(20, 220, 60, 20);
		tfPwd = new TextField();
		tfPwd.setEchoChar('*');
		tfPwd.setSize(200, 25);
		tfPwd.setLocation(90, 215);

		tfMsg = new TextField();
		tfMsg.setEditable(false);
		tfMsg.setSize(200, 30);
		tfMsg.setLocation(90, 250);

		regD = new Dialog(Lbody, "회원가입", true);
		regD.setSize(450, 250);
		regD.setLayout(null);

		reg = new Button("회원가입");
		reg.setSize(100, 30);
		reg.setLocation(330, 215);
		reg.addActionListener(new RegisterEvent());

		find = new Button("회원정보찾기");
		find.setSize(100, 30);
		find.setLocation(330, 250);
		find.addActionListener(new FindIdPassword());

		tfregid = new TextField();
		tfregid.setSize(200, 30);
		tfregid.setLocation(100, 70);

		tfregpw = new TextField();
		tfregpw.setSize(200, 30);
		tfregpw.setLocation(100, 110);

		tfregemail = new TextField();
		tfregemail.setSize(200, 30);
		tfregemail.setLocation(100, 150);
		tfregemail.addActionListener(new RegisterEvent());

		tfregm = new TextField();
		tfregm.setSize(200, 30);
		tfregm.setLocation(100, 190);
		tfregm.setEditable(false);
		tfregm.setText("회원가입 화면입니다.");
		reglid = new Label("I      D : ", Label.LEFT);
		reglid.setBounds(20, 70, 60, 20);
		reglpw = new Label("Password : ", Label.LEFT);
		reglpw.setBounds(20, 110, 60, 20);
		reglemail = new Label("E-mail : ", Label.LEFT);
		reglemail.setBounds(20, 150, 60, 20);

		regbDC = new Button("중복검사");
		regbDC.setSize(105, 35);
		regbDC.setLocation(320, 65);
		regbDC.addActionListener(new RegisterEvent());

		add = new Button("가입하기");
		add.setSize(105, 35);
		add.setLocation(320, 110);
		add.addActionListener(new RegisterEvent());

		back = new Button("돌아가기");
		back.setSize(105, 35);
		back.setLocation(320, 155);
		back.addActionListener(new RegisterEvent());

		regD.add(add);
		regD.add(back);
		regD.add(tfregid);
		regD.add(tfregpw);
		regD.add(tfregemail);
		regD.add(tfregm);
		regD.add(reglid);
		regD.add(reglpw);
		regD.add(reglemail);
		regD.add(regbDC);

		regD.setVisible(false);
		regD.setLocationRelativeTo(null);
		regD.addWindowListener(new RegisterEvent());

		lok = new Button("확인");
		lok.addActionListener(new FrameEvent());
		lok.addKeyListener(new FrameEvent());

		tflok = new Label("로그인에 성공했습니다.", Label.CENTER);

		E = new Dialog(Lbody, "ERROR", true);
		E.setSize(240, 150);
		E.setLayout(null);
		E.setLocationRelativeTo(null);
		E.addWindowListener(new DuplicatedIdExit());
		El1 = new Label("로그인 실패 : 중복로그인", Label.CENTER);
		El1.setBounds(0, 40, 240, 20);
		El2 = new Label("확인후 다시 시도 하세요", Label.CENTER);
		El2.setBounds(0, 60, 240, 20);

		Eback = new Button("돌아가기");
		Eback.setSize(90, 30);
		Eback.setLocation(20, 100);
		Eback.addActionListener(new FrameEvent());

		Econfirm = new Button("확인하기");
		Econfirm.setSize(90, 30);
		Econfirm.setLocation(130, 100);
		Econfirm.addActionListener(new DuplicateWindow());
		///////// 중복로그인 찾는 프레임//
		Dduplicate = new Dialog(Lbody, "중복로그인 ERROR 해결 마법사", true);
		Dduplicate.setSize(400, 225);
		Dduplicate.setLocationRelativeTo(null);
		Dduplicate.setLayout(null);
		Dduplicate.addWindowListener(new DuplicateWindow());
		DuptfLoginId = new TextField();
		DuptfLoginId.setSize(250, 30);
		DuptfLoginId.setLocation(110, 100);
		DuptfLoginId.setEditable(false);
		DuptfLoginTime = new TextField();
		DuptfLoginTime.setSize(250, 30);
		DuptfLoginTime.setLocation(110, 135);
		DuptfLoginTime.setEditable(false);
		DupLloginlist1 = new Label("현재 로그인되어있는 정보입니다.", Label.LEFT);
		DupLloginlist1.setBounds(20, 40, 400, 20);
		DupLloginlist2 = new Label("본인이 아니라면 로그오프해주세요", Label.LEFT);
		DupLloginlist2.setBounds(20, 65, 400, 20);
		DupLId = new Label("I               D : ", Label.LEFT);
		DupLId.setBounds(25, 105, 80, 20);
		DupLTime = new Label("로그인 시간 : ", Label.LEFT);
		DupLTime.setBounds(20, 140, 80, 20);
		DupBLogoff = new Button("로그오프");
		DupBLogoff.setSize(90, 30);
		DupBLogoff.setLocation(150, 175);
		DupBLogoff.addActionListener(new DuplicateWindow());

		DDok = new Dialog(Dduplicate, "로그인확인", true);
		DDok.setSize(220, 110);
		DDok.setLayout(null);
		DDok.setLocationRelativeTo(null);
		DDok.setVisible(false);

		DDLok = new Label("정상적으로 로그아웃 되었습니다.!", Label.CENTER);
		DDLok.setBounds(0, 40, 220, 30);

		DupDBconfirm = new Button("다시 로그인하기");
		DupDBconfirm.setSize(100, 20);
		DupDBconfirm.setLocation(60, 75);
		DupDBconfirm.addActionListener(new DuplicateWindow());

		DDok.add(DupDBconfirm);
		DDok.add(DDLok);
		Dduplicate.add(DupLloginlist1);
		Dduplicate.add(DupLloginlist2);
		Dduplicate.add(DupBLogoff);
		Dduplicate.add(DupLId);
		Dduplicate.add(DupLTime);
		Dduplicate.add(DuptfLoginId);
		Dduplicate.add(DuptfLoginTime);
		////////////////////////////////////////////////////

		Lbody.addWindowListener(new FrameEvent());
		Lbody.add(lid);
		Lbody.add(lpw);
		Lbody.add(tfId);
		Lbody.add(tfPwd);
		Lbody.add(tfMsg);
		Lbody.add(login);

		Lbody.add(reg);
		Lbody.add(find);
		Lbody.add(Plang);
		Lbody.setVisible(true);

		lokD.add(tflok);
		lokD.add(lok);
		lokD.setVisible(false);
		lokD.setLocationRelativeTo(null);
		E.add(El1);
		E.add(El2);
		E.add(Eback);
		E.add(Econfirm);
		E.setVisible(false);
		// 로그인단계 엔터키 구현
		tfId.addActionListener(new LoginEnter());
		login.addActionListener(new LoginEnter());
		tfPwd.addActionListener(new LoginEnter());
		// 회원정보찾기 이벤트 구현
		findId.addActionListener(new FindIdPassword());
		findPwd.addActionListener(new FindIdPassword());
		// 중복로그인, 입력된 id를 중복다이얼로그에 올려놓는 코드

		//
	}

	public class FrameEvent implements ActionListener, WindowListener, KeyListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getActionCommand().equals("돌아가기")) {
				E.setVisible(false);
			}
			if (e.getSource().equals("확인") || e.getActionCommand().equals("확인")) {
				Lbody.dispose();
				Thread obj = new Thread(new bodyFrame(tfId.getText()));
				obj.start();

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
				Lbody.setVisible(false);
				Ffind.setVisible(false);
				Thread obj = new Thread(new bodyFrame(tfId.getText()));
				obj.start();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class FindIdPassword implements ActionListener, WindowListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("회원정보찾기")) {
				Ffind.setVisible(true);
			}
			if (e.getActionCommand().equals("아이디 찾기")) {
				PfindId.setVisible(true);
				PfindPwd.setVisible(false);
				tfIdm.setText("E-mail을 입력하세요.");
				tfIdid.setText("");
				tfIdemail.setText("");
			}
			if (e.getActionCommand().equals("비밀번호 찾기")) {
				PfindId.setVisible(false);
				PfindPwd.setVisible(true);
				tfPwdm.setText("ID와 E-mail을 입력하세요.");
				tfPwdid.setText("");
				tfPwdemail.setText("");
			}

			if (e.getActionCommand().equals("돌아가기")) {
				Ffind.setVisible(false);
			}

			if (e.getSource() == tfPwdid || e.getSource() == tfPwdemail || e.getActionCommand().equals("찾기")) {
				findPassword = dao.findPassword(tfPwdid.getText(), tfPwdemail.getText());
				MemberVo data = new MemberVo();
				String id = "";
				String email = "";
				String pwd = "";
				for (int i = 0; i < findPassword.size(); i++) {
					data = (MemberVo) findPassword.get(i);
					id = data.getId();
					email = data.getEmail();
					pwd = data.getPassword();
				}
				if (tfPwdemail.getText().equals(email) && tfPwdid.getText().equals(id)) {
					tfPwdm.setText(pwd);
				} else {
					tfPwdm.setText("찾을 정보가 없습니다.");
				}
			}
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			Ffind.setVisible(false);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class RegisterEvent implements ActionListener, WindowListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("회원가입")) {
				regD.setVisible(true);
			}
			if (e.getSource() == tfregemail || e.getActionCommand().equals("중복검사")) {
				list = dao.list(tfregid.getText());
				MemberVo data = new MemberVo();
				String id = "";
				if (tfregid.getText().contains(" ")) {
					tfregm.setText("ID에 띄어쓰기 불가!!");
				} else {
					for (int i = 0; i < list.size(); i++) {
						data = (MemberVo) list.get(i);
						id = data.getId();
					}
					if (tfregid.getText().equals(id)) {
						tfregm.setText("중복됨, 다른ID를 입력하세요.");
					} else {
						tfregm.setText("사용가능한 ID입니다.");
					}
				}

			}

			if (e.getActionCommand().equals("가입하기")) {
				boolean b = false;
				if (tfregid.getText().contains(" ")) {
					tfregm.setText("ID에 띄어쓰기 불가!!");
				} else {
					if (tfregid.getText().equals("")) {
						tfregm.setText("ID를 입력해주세요");
					} else if (tfregpw.getText().equals("")) {
						tfregm.setText("비밀번호를 입력해주세요");
					} else if (tfregemail.getText().equals("")) {
						tfregm.setText("E-mail을 입력해주세요");

					} else {
						b = true;
					}
					if (b && dao.insert(tfregid.getText(), tfregpw.getText(), tfregemail.getText())) {
						tfregm.setText("성공적으로 가입되었습니다.");

					} else {
						tfregm.setText("가입에 실패했습니다.");
					}
				}

			}
			if (e.getActionCommand().equals("돌아가기")) {
				regD.setVisible(false);
			}
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			regD.setVisible(false);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class DuplicateWindow implements WindowListener, ActionListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			Dduplicate.setVisible(false);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("확인하기")) {
				E.setVisible(false);
				dao = new MemberDAO();
				Loginlist = dao.Loginlist();
				Dduplicate.setVisible(true);
			}
			if (e.getActionCommand().equals("로그오프")) {
				dao = new MemberDAO();
				Loginlist = dao.Loginlist();
				dao.Logout(DuptfLoginId.getText());
				DDok.setVisible(true);
			}
			if (e.getActionCommand().equals("다시 로그인하기")) {
				DDok.setVisible(false);
				Dduplicate.setVisible(false);

			}
		}
	}

	//// 중복안내뜨는 다이얼로그 엑스키만 있음
	public class DuplicatedIdExit implements WindowListener, ActionListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			E.setVisible(false);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

////정보찾는거 
	public class FindId implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tfIdemail || e.getActionCommand().equals("찾기")) {
				tfIdid.setText("");
				findIdenty = dao.findIdenty(tfIdemail.getText());
				MemberVo data = new MemberVo();
				String id = "";
				String email = "";
				for (int i = 0; i < findIdenty.size(); i++) {
					data = (MemberVo) findIdenty.get(i);
					id = data.getId();
					email = data.getEmail();
				}
				if (tfIdemail.getText().equals(email)) {
					tfIdid.setText(id);
					tfIdm.setText("찾으신 ID로 로그인해주세요.");
				} else {
					tfIdm.setText("찾으시는 정보가 없습니다.");
				}

			}
		}
	}

////로그인 
	public class LoginEnter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == tfPwd || e.getSource() == tfId || e.getActionCommand().equals("로그인")) {
				tfMsg.setText("");
				if (tfId.getText().equals("")) {
					tfMsg.setText("ID를 입력해주세요.");
				} else if (tfPwd.getText().equals("")) {
					tfMsg.setText("비밀번호를 입력해주세요.");
				} else {
					tfMsg.setText("입력한 정보를 다시 확인해주세요.");
				}
				list = dao.list(tfId.getText());
				Loginlist = dao.Loginlist();
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					if (Loginlist.size() != 0) {
						Logininfo data2 = (Logininfo) Loginlist.get(i);
						String id = data.getId();
						String id2 = data2.getId();
						String password = data.getPassword();
						System.out.println(data.getTime());
						System.out.println(id + " : " + password);
						if (!id.equals(id2)) {
							if (id.equals(tfId.getText()) && password.equals(tfPwd.getText())) {
								tfMsg.setText("로그인에 성공했습니다.");
								dao.Login(tfId.getText());
								lokD.setVisible(true);
							} else {
								tfMsg.setText("로그인 실패");
							}
						} else {
							tfMsg.setText("중복된 로그인!!");
							DuptfLoginId.setText(data2.getId());
							DuptfLoginTime.setText(data2.getTime());
							E.setVisible(true);

						}
					} else {
						String id = data.getId();
						String password = data.getPassword();
						if (id.equals(tfId.getText()) && password.equals(tfPwd.getText())) {
							tfMsg.setText("로그인에 성공했습니다.");
							dao.Login(tfId.getText());
							lokD.setVisible(true);
						} else {
							tfMsg.setText("로그인 실패");
						}
					}

				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void bodyFrame() {
		// TODO Auto-generated method stub

	}
}
