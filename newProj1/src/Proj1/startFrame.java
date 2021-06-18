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
		Lbody = new Frame("�α��� ȭ��");
		dao = new MemberDAO();
		sharesDao = new sharesDAO();

		//////////////////////// �����ݾ� �г�////

		/////////////////
		Font f = new Font("���� ���", Font.BOLD, 16);
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
		////////////// ��й�ȣ ã�� ������///////////
		Ffind = new Frame("ID / ��й�ȣ ã��");
		Ffind.setSize(450, 250);
		Ffind.setLayout(null);
		Ffind.setLocationRelativeTo(null);
		Ffind.addWindowListener(new FindIdPassword());

		findId = new Button("���̵� ã��");
		findId.setSize(100, 35);
		findId.setLocation(100, 40);

		findPwd = new Button("��й�ȣ ã��");
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

		tfIdm = new TextField("ã���� ID�� E-mail�� �Է����ּ���.");
		tfIdm.setSize(200, 25);
		tfIdm.setLocation(90, 95);
		tfIdm.setEditable(false);
		tfIdm.addActionListener(new FindIdPassword());

		findBid = new Button("ã��");
		findBid.setSize(100, 35);
		findBid.setLocation(320, 25);
		findBid.addActionListener(new FindId());

		findBidBack = new Button("���ư���");
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

		tfPwdm = new TextField("ID�� E-mail�� �Է����ּ���.");
		tfPwdm.setSize(200, 25);
		tfPwdm.setLocation(90, 95);
		tfPwdm.setEditable(false);
		tfPwdm.addActionListener(new FindIdPassword());

		findBpwd = new Button("ã��");
		findBpwd.setSize(100, 35);
		findBpwd.setLocation(320, 25);
		findBpwd.addActionListener(new FindIdPassword());

		findBpwdBack = new Button("���ư���");
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

		/////////////////////////////// �α��� ������
		lokD = new Dialog(Lbody, "�α���", true);
		lokD.setSize(200, 100);
		lokD.setLocation(50, 50);
		lokD.setLayout(new FlowLayout());

		Lbody.setSize(500, 300);
		Lbody.setLayout(null);
		Lbody.setLocationRelativeTo(null);

		login = new Button("�α���");
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

		regD = new Dialog(Lbody, "ȸ������", true);
		regD.setSize(450, 250);
		regD.setLayout(null);

		reg = new Button("ȸ������");
		reg.setSize(100, 30);
		reg.setLocation(330, 215);
		reg.addActionListener(new RegisterEvent());

		find = new Button("ȸ������ã��");
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
		tfregm.setText("ȸ������ ȭ���Դϴ�.");
		reglid = new Label("I      D : ", Label.LEFT);
		reglid.setBounds(20, 70, 60, 20);
		reglpw = new Label("Password : ", Label.LEFT);
		reglpw.setBounds(20, 110, 60, 20);
		reglemail = new Label("E-mail : ", Label.LEFT);
		reglemail.setBounds(20, 150, 60, 20);

		regbDC = new Button("�ߺ��˻�");
		regbDC.setSize(105, 35);
		regbDC.setLocation(320, 65);
		regbDC.addActionListener(new RegisterEvent());

		add = new Button("�����ϱ�");
		add.setSize(105, 35);
		add.setLocation(320, 110);
		add.addActionListener(new RegisterEvent());

		back = new Button("���ư���");
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

		lok = new Button("Ȯ��");
		lok.addActionListener(new FrameEvent());
		lok.addKeyListener(new FrameEvent());

		tflok = new Label("�α��ο� �����߽��ϴ�.", Label.CENTER);

		E = new Dialog(Lbody, "ERROR", true);
		E.setSize(240, 150);
		E.setLayout(null);
		E.setLocationRelativeTo(null);
		E.addWindowListener(new DuplicatedIdExit());
		El1 = new Label("�α��� ���� : �ߺ��α���", Label.CENTER);
		El1.setBounds(0, 40, 240, 20);
		El2 = new Label("Ȯ���� �ٽ� �õ� �ϼ���", Label.CENTER);
		El2.setBounds(0, 60, 240, 20);

		Eback = new Button("���ư���");
		Eback.setSize(90, 30);
		Eback.setLocation(20, 100);
		Eback.addActionListener(new FrameEvent());

		Econfirm = new Button("Ȯ���ϱ�");
		Econfirm.setSize(90, 30);
		Econfirm.setLocation(130, 100);
		Econfirm.addActionListener(new DuplicateWindow());
		///////// �ߺ��α��� ã�� ������//
		Dduplicate = new Dialog(Lbody, "�ߺ��α��� ERROR �ذ� ������", true);
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
		DupLloginlist1 = new Label("���� �α��εǾ��ִ� �����Դϴ�.", Label.LEFT);
		DupLloginlist1.setBounds(20, 40, 400, 20);
		DupLloginlist2 = new Label("������ �ƴ϶�� �α׿������ּ���", Label.LEFT);
		DupLloginlist2.setBounds(20, 65, 400, 20);
		DupLId = new Label("I               D : ", Label.LEFT);
		DupLId.setBounds(25, 105, 80, 20);
		DupLTime = new Label("�α��� �ð� : ", Label.LEFT);
		DupLTime.setBounds(20, 140, 80, 20);
		DupBLogoff = new Button("�α׿���");
		DupBLogoff.setSize(90, 30);
		DupBLogoff.setLocation(150, 175);
		DupBLogoff.addActionListener(new DuplicateWindow());

		DDok = new Dialog(Dduplicate, "�α���Ȯ��", true);
		DDok.setSize(220, 110);
		DDok.setLayout(null);
		DDok.setLocationRelativeTo(null);
		DDok.setVisible(false);

		DDLok = new Label("���������� �α׾ƿ� �Ǿ����ϴ�.!", Label.CENTER);
		DDLok.setBounds(0, 40, 220, 30);

		DupDBconfirm = new Button("�ٽ� �α����ϱ�");
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
		// �α��δܰ� ����Ű ����
		tfId.addActionListener(new LoginEnter());
		login.addActionListener(new LoginEnter());
		tfPwd.addActionListener(new LoginEnter());
		// ȸ������ã�� �̺�Ʈ ����
		findId.addActionListener(new FindIdPassword());
		findPwd.addActionListener(new FindIdPassword());
		// �ߺ��α���, �Էµ� id�� �ߺ����̾�α׿� �÷����� �ڵ�

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

			if (e.getActionCommand().equals("���ư���")) {
				E.setVisible(false);
			}
			if (e.getSource().equals("Ȯ��") || e.getActionCommand().equals("Ȯ��")) {
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
			if (e.getActionCommand().equals("ȸ������ã��")) {
				Ffind.setVisible(true);
			}
			if (e.getActionCommand().equals("���̵� ã��")) {
				PfindId.setVisible(true);
				PfindPwd.setVisible(false);
				tfIdm.setText("E-mail�� �Է��ϼ���.");
				tfIdid.setText("");
				tfIdemail.setText("");
			}
			if (e.getActionCommand().equals("��й�ȣ ã��")) {
				PfindId.setVisible(false);
				PfindPwd.setVisible(true);
				tfPwdm.setText("ID�� E-mail�� �Է��ϼ���.");
				tfPwdid.setText("");
				tfPwdemail.setText("");
			}

			if (e.getActionCommand().equals("���ư���")) {
				Ffind.setVisible(false);
			}

			if (e.getSource() == tfPwdid || e.getSource() == tfPwdemail || e.getActionCommand().equals("ã��")) {
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
					tfPwdm.setText("ã�� ������ �����ϴ�.");
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
			if (e.getActionCommand().equals("ȸ������")) {
				regD.setVisible(true);
			}
			if (e.getSource() == tfregemail || e.getActionCommand().equals("�ߺ��˻�")) {
				list = dao.list(tfregid.getText());
				MemberVo data = new MemberVo();
				String id = "";
				if (tfregid.getText().contains(" ")) {
					tfregm.setText("ID�� ���� �Ұ�!!");
				} else {
					for (int i = 0; i < list.size(); i++) {
						data = (MemberVo) list.get(i);
						id = data.getId();
					}
					if (tfregid.getText().equals(id)) {
						tfregm.setText("�ߺ���, �ٸ�ID�� �Է��ϼ���.");
					} else {
						tfregm.setText("��밡���� ID�Դϴ�.");
					}
				}

			}

			if (e.getActionCommand().equals("�����ϱ�")) {
				boolean b = false;
				if (tfregid.getText().contains(" ")) {
					tfregm.setText("ID�� ���� �Ұ�!!");
				} else {
					if (tfregid.getText().equals("")) {
						tfregm.setText("ID�� �Է����ּ���");
					} else if (tfregpw.getText().equals("")) {
						tfregm.setText("��й�ȣ�� �Է����ּ���");
					} else if (tfregemail.getText().equals("")) {
						tfregm.setText("E-mail�� �Է����ּ���");

					} else {
						b = true;
					}
					if (b && dao.insert(tfregid.getText(), tfregpw.getText(), tfregemail.getText())) {
						tfregm.setText("���������� ���ԵǾ����ϴ�.");

					} else {
						tfregm.setText("���Կ� �����߽��ϴ�.");
					}
				}

			}
			if (e.getActionCommand().equals("���ư���")) {
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
			if (e.getActionCommand().equals("Ȯ���ϱ�")) {
				E.setVisible(false);
				dao = new MemberDAO();
				Loginlist = dao.Loginlist();
				Dduplicate.setVisible(true);
			}
			if (e.getActionCommand().equals("�α׿���")) {
				dao = new MemberDAO();
				Loginlist = dao.Loginlist();
				dao.Logout(DuptfLoginId.getText());
				DDok.setVisible(true);
			}
			if (e.getActionCommand().equals("�ٽ� �α����ϱ�")) {
				DDok.setVisible(false);
				Dduplicate.setVisible(false);

			}
		}
	}

	//// �ߺ��ȳ��ߴ� ���̾�α� ����Ű�� ����
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

////����ã�°� 
	public class FindId implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tfIdemail || e.getActionCommand().equals("ã��")) {
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
					tfIdm.setText("ã���� ID�� �α������ּ���.");
				} else {
					tfIdm.setText("ã���ô� ������ �����ϴ�.");
				}

			}
		}
	}

////�α��� 
	public class LoginEnter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == tfPwd || e.getSource() == tfId || e.getActionCommand().equals("�α���")) {
				tfMsg.setText("");
				if (tfId.getText().equals("")) {
					tfMsg.setText("ID�� �Է����ּ���.");
				} else if (tfPwd.getText().equals("")) {
					tfMsg.setText("��й�ȣ�� �Է����ּ���.");
				} else {
					tfMsg.setText("�Է��� ������ �ٽ� Ȯ�����ּ���.");
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
								tfMsg.setText("�α��ο� �����߽��ϴ�.");
								dao.Login(tfId.getText());
								lokD.setVisible(true);
							} else {
								tfMsg.setText("�α��� ����");
							}
						} else {
							tfMsg.setText("�ߺ��� �α���!!");
							DuptfLoginId.setText(data2.getId());
							DuptfLoginTime.setText(data2.getTime());
							E.setVisible(true);

						}
					} else {
						String id = data.getId();
						String password = data.getPassword();
						if (id.equals(tfId.getText()) && password.equals(tfPwd.getText())) {
							tfMsg.setText("�α��ο� �����߽��ϴ�.");
							dao.Login(tfId.getText());
							lokD.setVisible(true);
						} else {
							tfMsg.setText("�α��� ����");
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
