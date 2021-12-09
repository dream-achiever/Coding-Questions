// Standard Code for DSU

import java.util.*;

import java.io.*;

class DSU {
    int n;
    int parent[];
    int sz[];

    DSU(int n){
        this.n=n;
        this.parent = new int[n+1];
        this.sz = new int[n+1]; 

        for(int i=1;i<=n;i++){
            parent[i]=i;
            sz[i]=1;
        }


    }

    public int find(int x){
        ArrayList<Integer> anc = new ArrayList<>();

        while(parent[x]!=x){
            anc.add(x);
            x = parent[x];
        }

        for(int i=0;i<anc.size();i++){
            parent[anc.get(i)]=x;
        }

        return x;
    }

    public boolean isSame(int a, int b){
        if(find(a)==find(b)){
            return true;
        }
        return false;
    }

    public void unite(int a, int b){

        if(isSame(a,b)){
            return;
        }

        a=find(a);
        b=find(b);

        if(sz[a]<sz[b]){
            int temp = a;
            a=b;
            b=temp;

        }

        parent[b]=a;
        sz[a]+=sz[b];
    }

}

class SortByWeight implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a.get(2)>b.get(2)){
            return 1;
        }
        else if(a.get(2)<b.get(2)){
            return -1;
        }
        return 0;
    }

}

class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

        int a,b,c;

        for(int i=0;i<n;i++){
            ArrayList<Integer> edge = new ArrayList<>();
             a = sc.nextInt();

             b = sc.nextInt();

            c = sc.nextInt();

            edge.add(a);

            edge.add(b);

            edge.add(c);

            edges.add(edge);
        }

        Collections.sort(edges,new SortByWeight());

        DSU dsu = new DSU(m);
        int ans=0;

        for(int i=0;i<n;i++){
            a = edges.get(i).get(0);
            b = edges.get(i).get(1);
            c = edges.get(i).get(2);

            if(dsu.isSame(a,b)==false){
                dsu.unite(a,b);
                ans+=c;
            }
        }
        System.out.println(ans);
    }
}
