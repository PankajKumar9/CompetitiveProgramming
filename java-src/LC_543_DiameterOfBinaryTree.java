import java.util.*;
public class LC_543_DiameterOfBinaryTree {

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      private void MarkKidsVis(boolean[] vis, int x){
          if((2*x)+1<vis.length){
          vis[(2*x)+1]=true;}
          if((2*x)+2<vis.length){
              vis[(2*x)+2]=true;}
          if((2*x)+1<vis.length || (2*x)+2<vis.length){
              return;
          }
          MarkKidsVis(vis, (2*x)+1);
          MarkKidsVis(vis, (2*x)+2);


      }
      TreeNode(Integer[] a){
          int L = 2*a.length;
          int[] aux = new int[L];
          for(int i =0;i<L;i++){aux[i]=-5;}
          boolean[] vis = new boolean[L];
          int j = 0;
          Deque<Integer> queue= new LinkedList<Integer>();
          for(int i = 0;i<a.length;i++){
              while(vis[j]){
                  j=j+1;
              }
              if(a[i]!=null){
                  aux[j] = a[i];
                  vis[j]= true;

              }else{
                 vis[j]=true;
                 MarkKidsVis(vis,j);
              }
          }

          Deque<TreeNode> tq= new LinkedList<TreeNode>();
          TreeNode root = this;
          tq.addLast(this);
          TreeNode curr = this;
          Integer Number ;
          Integer x;Integer y;
          int i = 0;
          while(!tq.isEmpty()) {
                curr = tq.removeFirst();
                if(i==L){
                    break;
                }
                curr.val = aux[i];
                i++;
                curr.left= new TreeNode(-5);
                curr.right= new TreeNode(-5);
                tq.addLast(curr.left);
                tq.addLast(curr.right);
          }

          tq= new LinkedList<TreeNode>();
          tq.addLast(root);
          while(!tq.isEmpty()){
              curr = tq.removeFirst();
                if(curr.left != null){
                    if(curr.left.val ==-5){
                        curr.left = null;
                    }else{
                        tq.addLast(curr.left);
                    }
                }
              if(curr.right != null){
                  if(curr.right.val ==-5){
                      curr.right = null;
                  }else{
                      tq.addLast(curr.right);
                  }
              }

          }
          this.val= root.val;
          this.left = root.left;
          this.right = root.right;


      }
  }
    public static void main(String args[]){
        Integer[] a = new Integer[]{2,1,4,3,null,5};
        TreeNode t = new TreeNode(a);
        System.out.println("Dia = "+diameterOfBinaryTree(t));
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(t);
        TreeNode curr;
        while(!q.isEmpty()){
            curr = q.removeFirst();
            System.out.print(curr.val+" ");
            if(curr.left !=null){

                q.addLast(curr.left);
            }
            if(curr.right !=null){

                q.addLast(curr.right);
            }

        }

    }
    public static int maxx = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        int a = 0; int b = 0;int d;int e;
        d = 0; e= 0;
        if(root.left != null){
            a= treeheight(root.left);
        }
        if(root.right != null){
            b= treeheight(root.right);
        }
        System.out.println("Val is "+root.val);
        System.out.println("a is "+root.val);
        System.out.println("b is "+root.val);
        int c = 0;
        if(a!=0 && b!=0){
            c = a+b;}else{
            c= Math.max(a,b);
        }

        if(root.right != null){
            d= diameterOfBinaryTree(root.right);
        }
        if(root.left != null){
            e = diameterOfBinaryTree(root.left);
        }
        return Math.max(c,Math.max(d,e));

    }



    public static int treeheight(TreeNode root){
        int a = 0;
        int b = 0;
        if(root.left != null){
            a = treeheight(root.left);
        }
        if(root.right != null){
            b = treeheight(root.right);
        }
        return 1 + Math.max(a,b);
    }



}

