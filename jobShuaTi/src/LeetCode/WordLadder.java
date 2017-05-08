package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordLadder {
	int[][] imageVertix=null;
	int endWordIndex=-1;
	int[] path=null;
	ArrayList<String> wordStrings=null;
	private int manyDis(String one, String two){
		if (one.length()!=two.length()) System.exit(0);;
		int dis=0;
		for (int i=0;i<one.length();++i){
			if (one.charAt(i)!=two.charAt(i)) dis++;
		}
		return dis;
	}
	public void createMap(List<String> wordList,String beginWord, String endWord){
//		endWordIndex=wordList.indexOf(endWord);
		wordStrings=new ArrayList<>(wordList);
		int beginflag=-1;
		for (int ii=0;ii<wordList.size();++ii){
			if (wordList.get(ii).equals(endWord)){
				endWordIndex=ii;
			}
			if (wordList.get(ii).equals(beginWord)){
				beginflag=ii;
			}
		}
		if (beginflag==-1){
			wordStrings.add(0, beginWord);
			endWordIndex++;
		}else{
			
			String temp=wordStrings.get(0);
			if (temp.equals(endWord)) endWordIndex=beginflag;
			wordStrings.set(0, wordStrings.get(beginflag));
			wordStrings.set(beginflag, temp);
			
		}
//		System.out.println(wordStrings.toString());
		imageVertix=new int[wordStrings.size()][wordStrings.size()];
		for (int i1=0;i1<wordStrings.size();++i1){
			imageVertix[i1][i1]=0;
			for (int j=i1+1;j<wordStrings.size();++j){
				if (manyDis(wordStrings.get(i1), wordStrings.get(j))==1){
					imageVertix[i1][j]=1;
					imageVertix[j][i1]=1;
				}else{
					imageVertix[i1][j]=-1;
					imageVertix[j][i1]=-1;
				}
			}
		}
		for(int ii=0;ii<imageVertix.length;++ii){
			for (int jj=0;jj<imageVertix.length;++jj){
				System.out.print(imageVertix[ii][jj]+",");
			}
			System.out.println();
		}
	}
	public int digistka(int[][] data, int sourceIndex){
		int[] dist=new int[data.length];
		boolean[] visted=new boolean[data.length];
		path=new int[data.length];
		for (int i=0;i<data.length;++i){
			if (data[0][i]==1 && i!=sourceIndex){
				dist[i]=1;
				path[i]=sourceIndex;
			}else{
				dist[i]=Integer.MAX_VALUE;
				path[i]=-1;
			}
			visted[i]=false;
			path[sourceIndex]=sourceIndex;
			dist[sourceIndex]=0;
		}
		visted[sourceIndex]=true;
		for(int j=1;j<data.length;++j){
			int minValue=Integer.MAX_VALUE;
			int u=-1;
			for (int k=0;k<data.length;++k){
				if (visted[k]==false && dist[k]<minValue){
					minValue=dist[k];
					u=k;
				}
			}
			visted[u]=true;
			for (int m=0;m<data.length;++m){
				if (visted[m]==false && data[u][m]>0 && minValue+data[u][m]<dist[m]){
					dist[m]=minValue+data[u][m];
					path[m]=u;
				}
			}
		}
		return dist[endWordIndex]+1;
	}
	public void showPath(int end, int start){
		for(int i=0;i<path.length;++i){
			
		System.out.print(path[i]+",");
		}
		System.out.println();
		Stack<Integer> stack=new Stack<>();
		int u=end;
		while(end!=start){
			stack.push(end);
			end=path[end];
		}
		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        createMap(wordList, beginWord, endWord);
        return digistka(imageVertix, 0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input={"hot","dot","dog","lot","log","cog"};
		ArrayList<String> wordList=new ArrayList<>();
		for (int i=0;i<input.length;++i){
			wordList.add(input[i]);
		}
		String beginWord="hit";
		String endWord="cog";
		WordLadder test=new WordLadder();
		System.out.println(test.ladderLength(beginWord, endWord, wordList));
		test.showPath(6, 0);
	}

}
