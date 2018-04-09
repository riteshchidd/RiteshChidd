
import java.util.ArrayList;

public class SuggestionsBuilder {
    
   static ArrayList<String> alSuggestions = new ArrayList<String>();
    
   public static void main(String args[]) {
      String[] stopWords = {"is", "a", "can", "the"};
      String[] tokenStream = {"The", "beautiful", "girl", "from", "the", "farmers", "market", ".", "I", "like","chewing", "gum", "." };
      
      suggestions( tokenStream, stopWords);
      System.out.println("Final Suggestion :" +alSuggestions);
   }
   public static ArrayList suggestions(String[] tokenStream,String[] stopWords){
       
       for (int i=0;i<tokenStream.length;i++){
        if (contains(tokenStream[i],stopWords)==false){ 
            String combination ;
                   combination=tokenStream[i];
            alSuggestions.add(tokenStream[i]);
              for(int p=i+1 ; p<tokenStream.length;p++) {
                  if (!contains(tokenStream[p],stopWords)){
                      
                      combination=combination+" "+tokenStream[p];
                      alSuggestions.add(combination);
                      
                  }
                  else{
                     p=tokenStream.length;
                  }
          }
      }
    }
    return alSuggestions;
    }
  public static boolean contains(String tokenStream,String[] stopWords){
       
       for (int i=0; i<stopWords.length;i++){
               if (tokenStream.toLowerCase().equals(stopWords[i]) || tokenStream.length()==1 )
               {
                  return true;
               }
              
       }
     return false;  
   }
}