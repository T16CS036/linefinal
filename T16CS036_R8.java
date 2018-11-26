/**
 * 実機NXT用ロボットクラス
 */
public class T16CS036_R8 extends Robot
{
    /** leJOS での起動用 main 関数 */
    static void main(String[] args) { 
	try {
	    // 時間計測
	    Long time = System.currentTimeMillis();

	    // ロボットオブジェクトを生成して実行
	    new T16CS036_R8().run();

	    time = (System.currentTimeMillis() - time) / 1000;
	    System.out.println("Time = "+time.intValue() + "sec");

	    // 7秒待ってから停止
	    Thread.sleep(7000);
	}catch (InterruptedException e) {
	    ;
	}
    }

    /**
	 * 実行用関数
	 */
	public void run() throws InterruptedException
	{
		/* 学習した最適政策を表す配列 */
		int[] q = new int[8];
		q[0] = 46;
		q[1] = 11;
		q[2] = 0;
		q[3] = 9;
		q[4] = 12;
		q[5] = 0;
		q[6] = 8;
		q[7] = 33;

		while (true) {
			/* 現在の状態を観測 */
			int state = getState();

			/* 行動を選択する */
			int action = q[state];

			/* その状態における最適な行動を実行 */
			moveRobot(action);

			// delay()メソッドは、Robot.javaに応じていずれかの機能を実行する
			// 速度調整＆画面描画 (シミュレーター用)
			// ESCAPEボタン押下時に割り込みを発生させる (実機NXT用)
			delay();

			// ゴールに到達すれば終了
			if (isOnGoal())
				break;
		}
	}
	public int getState(){ 

		int stateNum = 0;

		if(getColor(LIGHT_A) == WHITE && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == WHITE)
			stateNum = 0;
		else if(getColor(LIGHT_A) == WHITE && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == BLACK)
			stateNum = 1;
		else if(getColor(LIGHT_A) == WHITE && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == WHITE)
			stateNum = 2;
		else if(getColor(LIGHT_A) == WHITE && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == BLACK)
			stateNum = 3;
		else if(getColor(LIGHT_A) == BLACK && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == WHITE)
			stateNum = 4;
		else if(getColor(LIGHT_A) == BLACK && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == BLACK)
			stateNum = 5;
		else if(getColor(LIGHT_A) == BLACK && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == WHITE)
			stateNum = 6;
		else if(getColor(LIGHT_A) == BLACK && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == BLACK)
			stateNum = 7;

		return stateNum;
	}
	/**
	 * ロボットを移動する
	 */
	public void moveRobot(int action)
	{
		// 壁がないことを確認して移動する
		if(action == 0) // STRAIGHT
			goForward(1);
		else if(action != 0) {
			goForward(1);
			if(action == 1) // LEFT
				turnLeft(5);
			else if(action == 2) // RIGHT
				turnRight(5);
			else if(action == 3) // LEFT
				turnLeft(10);
			else if(action == 4) // RIGHT
				turnRight(10);
			else if(action == 5) // LEFT
				turnLeft(15);
			else if(action == 6) // RIGHT
				turnRight(15);
			else if(action == 7) // LEFT
				turnLeft(20);
			else if(action == 8) // RIGHT
				turnRight(20);
			else if(action == 9) // LEFT
				turnLeft(25);
			else if(action == 10) // RIGHT
				turnRight(25);
			else if(action == 11) // LEFT
				turnLeft(30);
			else if(action == 12) // RIGHT
				turnRight(30);
			else if(action == 13) // LEFT
				turnLeft(35);
			else if(action == 14) // RIGHT
				turnRight(35);
			else if(action == 15) // LEFT
				turnLeft(40);
			else if(action == 16) // RIGHT
				turnRight(40);
			else if(action == 17) // LEFT
				turnLeft(45);
			else if(action == 18) // RIGHT
				turnRight(45);
			else if(action == 19) // LEFT
				turnLeft(50);
			else if(action == 20) // RIGHT
				turnRight(50);
			else if(action == 21) // LEFT
				turnLeft(55);
			else if(action == 22) // RIGHT
				turnRight(55);
			else if(action == 23) // LEFT
				turnLeft(60);
			else if(action == 24) // RIGHT
				turnRight(60);
			else if(action == 25) // LEFT
				turnLeft(65);
			else if(action == 26) // RIGHT
				turnRight(65);
			else if(action == 27) // LEFT
				turnLeft(70);
			else if(action == 28) // RIGHT
				turnRight(70);
			else if(action == 29) // LEFT
				turnLeft(75);
			else if(action == 30) // RIGHT
				turnRight(75);
			else if(action == 31) // LEFT
				turnLeft(80);
			else if(action == 32) // RIGHT
				turnRight(80);
			else if(action == 33) // LEFT
				turnLeft(85);
			else if(action == 34) // RIGHT
				turnRight(85);
			else if(action == 35) // LEFT
				turnLeft(90);
			else if(action == 36) // RIGHT
				turnRight(90);
			else if(action == 37) // LEFT
				turnLeft(95);
			else if(action == 38) // RIGHT
				turnRight(95);
			else if(action == 39) // LEFT
				turnLeft(100);
			else if(action == 40) // RIGHT
				turnRight(100);
			else if(action == 41) // LEFT
				turnLeft(105);
			else if(action == 42) // RIGHT
				turnRight(105);
			else if(action == 43) // LEFT
				turnLeft(110);
			else if(action == 44) // RIGHT
				turnRight(110);
			else if(action == 45) // LEFT
				turnLeft(115);
			else if(action == 46) // RIGHT
				turnRight(115);
			else if(action == 47) // LEFT
				turnLeft(120);
			else if(action == 48) // RIGHT
				turnRight(120);
			else if(action == 49) // LEFT
				turnLeft(125);
			else if(action == 50) // RIGHT
				turnRight(125);
			else if(action == 51) // LEFT
				turnLeft(130);
			else if(action == 52) // RIGHT
				turnRight(130);
			else if(action == 53) // LEFT
				turnLeft(135);
			else if(action == 54) // RIGHT
				turnRight(135);
			else if(action == 55) // LEFT
				turnLeft(140);
			else if(action == 56) // RIGHT
				turnRight(140);
			else if(action == 57) // LEFT
				turnLeft(145);
			else if(action == 58) // RIGHT
				turnRight(145);
			else if(action == 59) // LEFT
				turnLeft(150);
			else if(action == 60) // RIGHT
				turnRight(150);
			else if(action == 61) // LEFT
				turnLeft(155);
			else if(action == 62) // RIGHT
				turnRight(155);
			else if(action == 63) // LEFT
				turnLeft(160);
			else if(action == 64) // RIGHT
				turnRight(160);
			else if(action == 65) // LEFT
				turnLeft(165);
			else if(action == 66) // RIGHT
				turnRight(165);
			else if(action == 67) // LEFT
				turnLeft(170);
			else if(action == 68) // RIGHT
				turnRight(170);
			else if(action == 69) // LEFT
				turnLeft(175);
			else if(action == 70) // RIGHT
				turnRight(175);
			else if(action == 71) // for the exception
				goBackward(1);
			// ロボットの位置座標を更新
		}
	}
	public void turnLeft(int angle){
		if(getColor(LIGHT_A) == WHITE || getColor(LIGHT_C) == BLACK || getColor(LIGHT_C) == BLUE)
			rotateLeft(angle);
	}
	public void turnRight(int angle){
		if(getColor(LIGHT_A) == BLACK || getColor(LIGHT_A) == BLUE || getColor(LIGHT_C) == WHITE)
			rotateRight(angle);
	}
	public void goForward(int moveSpeed){
		if(getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE)
			forward(moveSpeed);
	}
	public void goBackward(int moveSpeed){
		if(getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE)
			backward(moveSpeed);
	}
}