import java.util.ArrayList;
import java.util.Random;
import java.math.*;
/**
 * Ｑ学習を行うクラス
 */
public class QLearning {

	/**
	 * Ｑ学習を行うオブジェクトを生成する
	 * @param states  状態数
	 * @param actions 行動数
	 * @param alpha   学習率（0.0〜1.0）
	 * @param gamma   割引率（0.0〜1.0）
	 */
	public QLearning(int states, int actions, double alpha, double gamma)
	{
		this.qTable = new double[states][actions];
		this.alpha = alpha;
		this.gamma = gamma;
		this.actions = actions;
	}

	/**
	 * epsilon-Greedy 法により行動を選択する
	 * @param state   現在の状態
	 * @param epsilon ランダムに行動を選択する確率（0.0〜1.0）
	 * @return 選択された行動番号
	 */
	public int selectAction(int state, double epsilon)
	{
		//割引率により次の行動がrandomかどうか
		if(random.nextDouble() < epsilon)
			return rand1.nextInt(actions);

		//最終的なMaxQの値がきまれば、それに沿って次の行動を取る
		return getNextAcQ(state);
	}

	/**
	 * Greedy 法により行動を選択する
	 * @param state   現在の状態
	 * @return 選択された行動番号
	 */
	public int selectAction(int state)
	{
		//MAXの値を次の行動として選択する
//		printTable(state);
		return getNextAcQ(state);
	}

//				System.out.printf("%6.1f",qTable[i][j]); //変数の全部で6桁内浮動小数点1桁まで

	  public void printQTable(int states) 
	  {
		  System.out.println("Start");
		  for (int i=0; i < states; i++) {
			  double maxQ = qTable[i][0];
			  int nxtAc = 0;
			  for (int j=0; j < actions; j++) {
				  if(qTable[i][j] > maxQ) {
					  maxQ = qTable[i][j];
					  nxtAc = j;
				  }
				  
			  }
			  //最後のQテーブルを表示する
			  System.out.println("State [" + i+"]"+ "->Action[" + nxtAc+"]");
			  System.out.println();
		  }
		  System.out.println("Finish");
	  }
	/**
	 * Ｑ値を更新する
	 * @param before 状態
	 * @param action 行動
	 * @param after  遷移後の状態
	 * @param reward 報酬
	 */
	public void update(int before, int action, int after, double reward)
	{
		//Q(s,a)の公式ー更新するための公式
		qTable[before][action] = qTable[before][action] + alpha * (reward + (gamma * getMaxQ(after)) - qTable[before][action]);
	}


	public int getNextAcQ(int state)
	{
		int nextAc = 0;
		boolean randFlag = false;//複数道がある場合ー決定するための乱数
		double MaxQ = qTable[state][0];
		acList.clear(); //リスト削除-初期化するため
		
		
		
		//MaxQを持っている行動をリストに記録する
		for(int i = 1; i < actions; i++) {
			if(qTable[state][i] > MaxQ) {
				acList.clear();		
				MaxQ = qTable[state][i];
				nextAc = i;
				acList.add(i);
				randFlag= false;
			}
			
			//これはなかったら、1つパータンしか動かない（最初に見つかったパータン）
			else if(qTable[state][i] == MaxQ) {
				acList.add(i);
				randFlag = true; //同じMaxQの値を持っている複数の行動パータンがある場合、randomで選択するための条件
			}
		}

		//同じMaxQを持っている複数の行動からランダムを選択するため
		if(randFlag == true)
			nextAc = acList.get(rand2.nextInt(acList.size()));
		return nextAc;
	}
	public double getMaxQ(int state)
	{
		double MaxQ = qTable[state][0];

		//最終的なMaxQを返す関数
		for(int i = 1; i < actions; i++) {
			if(qTable[state][i] > MaxQ)
				MaxQ = qTable[state][i];
			
		}
		return MaxQ;
	}


	//フィールド
	private double qTable[][] = null;
	private double alpha = 0; // 学習率
	private double gamma = 0; // 割引率
	private int actions = 0;  // 行動数
	private ArrayList<Integer> acList = new ArrayList<>(); // 行動の保存用のリスト
	private Random random = new Random(); // ランダム用の変数
	private Random rand1 = new Random();
	private Random rand2 = new Random();
}