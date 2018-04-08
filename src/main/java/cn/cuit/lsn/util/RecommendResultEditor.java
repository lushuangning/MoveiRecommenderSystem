package cn.cuit.lsn.util;

import java.io.*;

public class RecommendResultEditor {

    public static void resultSplit(File file1, File file2){

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            FileWriter fw = new FileWriter(file2);
            StringBuffer addNext = new StringBuffer();
            String s = null;
            String[] line;
            String userId = null;
            String infos = null;
            String[] info = null;
            String itemId = null;
            String itemScore = null;
            String[] item = null;
            while ((s = br.readLine()) != null){
                line = s.split("\t");
                userId = line[0];
                infos = line[1].substring(1,line[1].length()-1);
                info = infos.split(",");
                for (int i = 0;i<info.length;i++){
                    addNext.delete(0,addNext.length());
                    item = info[i].split(":");
                    itemId = item[0];
                    itemScore = item[1];
                    addNext.append(userId);

                    addNext.append("," + itemId + "," + itemScore);
                    fw.write(addNext.toString() + "\n");
                }
            }
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){

        }
    }
}
