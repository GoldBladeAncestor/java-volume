
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:Eric
 * @Date:Created in 21:01 2019/2/8
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int lengthOfMonth = now.lengthOfMonth();
        System.out.println("lengthOfMonth:"+lengthOfMonth);
        LocalDate date = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date);
        String firstDay = date.getDayOfWeek().toString().substring(0,3);
        System.out.println("firstDay:"+firstDay);
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("firstDay",firstDay);
        resultMap.put("space","");
        resultMap.put("flag","0");
        resultMap.put("result","");
        String []weeks = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for (String week:weeks) {
            resultMap = nameWeek(week,resultMap);
        }
        resultMap.put("result",resultMap.get("result") + "\r\n" + resultMap.get("space") + "\r\n");
        int index = Integer.parseInt(resultMap.get("flag"));
        for (int i = index + 1; i <= lengthOfMonth; i++) {
            String space = " ";
            if(i > 9){
                space = "";
            }
            resultMap.put("result",resultMap.get("result") + space + i + "   ");
            LocalDate weekDay = date.withDayOfMonth(i);
            if(weekDay.getDayOfWeek().toString().substring(0,3).toLowerCase().equals("sun")){
                resultMap.put("result",resultMap.get("result") + "\r\n");
            }
        }
        int nowDay = now.getDayOfMonth();
        resultMap.put("result",
                resultMap.get("result").replace(" " + nowDay + " "," " + nowDay + "*"));
        System.out.println(resultMap.get("result"));
    }
    public static Map<String,String> nameWeek(String weekName, Map<String,String> resultMap){
        resultMap.put("result",resultMap.get("result") + weekName + "  ");
        int index = Integer.parseInt(resultMap.get("flag"));
        if(resultMap.get("firstDay").toLowerCase().equals(weekName.toLowerCase()) || index > 0){
             index +=1 ;
            resultMap.put("flag",index + "");
            resultMap.put("space",resultMap.get("space") + " " + resultMap.get("flag") + "   ");
            return resultMap;
        }
        resultMap.put("space",resultMap.get("space") + "     ");
        return resultMap;
    }
}
