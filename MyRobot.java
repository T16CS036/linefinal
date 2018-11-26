/**
 * ロボットクラスの作成例：単純なライントレーサーロボット
 */
public class MyRobot extends Robot
{
	/**
	 * 実行用関数
	 */
	public void run() throws InterruptedException
	{
		// ここをがんばって作る

		// step 1:	Q学習する
		// QLearningのインスタンスを作る	
		int states = 8; // 状態数
		int actions = 71;	// 行動数
		double alpha = 0.5; // 学習率
		double gamma = 0.5; // 割引率

		QLearning qlearn = new QLearning(states, actions, alpha, gamma);

		int trials = 500; //500 // 強化学習の試行回数 
		int steps = 500; //100 // 1試行あたりの最大ステップ数

		// 試行回数だけ繰り返し
		for(int t = 0; t < trials; t++){

			/* ロボットを初期位置に戻す */
			init();

			// ステップ数だけ繰り返し
			for(int s = 0; s < steps; s++){

				/*--------------- ε-Greedy 法により行動を選択 ---------------*/
				// 現在の状態番号を取得する
				int state = getState();

				// ランダムに行動を選択する確率
				double epsilon = 0.5;
				int action = qlearn.selectAction(state, epsilon);
				//int action = ql.selectAction(state);

				/*--------------- 選択した行動を実行 (ロボットを移動する) ---------------*/
				moveRobot(action);

				/*--------------- 新しい状態を観測＆報酬を得る ---------------*/
				//次の状態番号
				int	after = getState(); // 頑張って取得する
				//System.out.println(after);

				// 状態afterにおける報酬
				int reward = 0; // 頑張って取得する

				// Goal に到達したら 100 報酬を与え、普通の通路なら -10
				if(isOnGoal())
					reward = 2000;
				else if(getColor(LIGHT_B) == BLACK)
					reward = 50;
				else if(getColor(LIGHT_B) == BLUE)//make sure it close to the goal
					reward = 900;
				else if(getColor(LIGHT_B) == WHITE)
					reward = -100;

				/*--------------- Q 値を更新 ---------------*/
				// qlearingインスタンスから呼び出す
				qlearn.update(state, action, after, reward);

				// ゴールに到達すれば終了
				if (isOnGoal())
					break;

			}
		}

		/* 学習終了で、最後の成果を出す */
		init(); // ロボットを初期位置に戻す
		finishTest(qlearn);
		//最短の結果のQテーブルを確認するため
		qlearn.printQTable(states);
		// Done
		
		System.out.println("Done!!!!!!!!!!!!!!!!!");
		//System.exit(0);
	}
	//the state of Robot 
	public int getState(){ 

		int stNum = 0;

		if(getColor(LIGHT_A) == WHITE && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == WHITE)
			stNum = 0;
		else if(getColor(LIGHT_A) == WHITE && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == BLACK)
			stNum = 1;
		else if(getColor(LIGHT_A) == WHITE && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == WHITE)
			stNum = 2;
		else if(getColor(LIGHT_A) == WHITE && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == BLACK)
			stNum = 3;
		else if(getColor(LIGHT_A) == BLACK && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == WHITE)
			stNum = 4;
		else if(getColor(LIGHT_A) == BLACK && getColor(LIGHT_B) == WHITE && getColor(LIGHT_C) == BLACK)
			stNum = 5;
		else if(getColor(LIGHT_A) == BLACK && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == WHITE)
			stNum = 6;
		else if(getColor(LIGHT_A) == BLACK && (getColor(LIGHT_B) == BLACK || getColor(LIGHT_B) == BLUE) && getColor(LIGHT_C) == BLACK)
			stNum = 7;

		return stNum;
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
	public void finishTest(QLearning qlearn) throws InterruptedException{

		while(true){
			// 現在の状態番号を取得する
			int state = getState();

			// デバッグ用
			//System.out.println("A:" + getColor(LIGHT_A) + " B:" + getColor(LIGHT_B) + " C:" + getColor(LIGHT_C));

			// ランダムに行動を選択する確率
			int action = qlearn.selectAction(state);

			// 選択した行動を実行 (ロボットを移動する)
			moveRobot(action);

			// 速度調整＆画面描画
			delay();

			// ゴールに到達すれば終了
			if (isOnGoal())
				break;
		}

	}
}
