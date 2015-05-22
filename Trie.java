
package DS;

public class Trie{
   class TrieNode{
        char letter;
        TrieNode[] links;
        boolean fullword;

        public TrieNode(char letter, boolean fullword){
            this.letter=letter;
            this.links=new TrieNode[26];
            this.fullword=fullword;
        }
   }

   private TrieNode root;

    public Trie(){
        root=new TrieNode('r',false);
    }

    public void add(String s){
        char[] sarr=s.toCharArray();
        TrieNode p=root;
        for(int i=0;i<s.length();i++){
            if(p.links[sarr[i]-'a']!=null)
                p=p.links[sarr[i]-'a'];
            else{
                TrieNode newnode=new TrieNode(sarr[i],false);
                p.links[sarr[i]-'a']=newnode;
                p=newnode;
            }
        }
        p.fullword=true;
    }

    public boolean contains(String s){
        char[] arr=s.toCharArray();
        TrieNode p=root;
        int j=0;
        while(j<s.length()){
            if(p.links[arr[j]-'a']==null)
                return false;
            else
                p=p.links[arr[j]-'a'];
            j++;
        }
        return p.fullword;
    }

    public boolean isPrefix(String s){
        char[] arr=s.toCharArray();
        TrieNode p=root;
        int j=0;
        while(j<s.length()){
            if(p.links[arr[j]-'a']==null)
                return false;
            else
                p=p.links[arr[j]-'a'];
            j++;
        }
        return true;
    }
}
