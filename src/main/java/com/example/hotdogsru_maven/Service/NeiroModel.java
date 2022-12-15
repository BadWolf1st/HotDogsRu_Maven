package com.example.hotdogsru_maven.Service;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Tensor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;

public class NeiroModel {
    public String getAnswer(String path, SavedModelBundle model) throws IOException {
        float[] Picture = resizePic(path);
        //Создаем тензор
        Tensor<Float> tensor = Tensor.create(new long[]{1, 512, 512, 3}, FloatBuffer.wrap(Picture)); //1-количество картинок, 512-размер картинки, 3-количество каналов
        //Получаем результат
        Tensor<?> result = model.session().runner()
                .feed("serving_default_sequential_input:0", tensor) //Входной тензор
                .fetch("StatefulPartitionedCall:0") //Выходной тензор
                .run().get(0);
        //Выводим результат в массив 1-9
        float[][] resultArray = new float[1][9];
        result.copyTo(resultArray);

        //Получаем индекс максимального значения
        int index = 0;
        float max = resultArray[0][0];
        for (int i = 0; i < resultArray[0].length; i++) {
            if (resultArray[0][i] > max) {
                max = resultArray[0][i];
                index = i;
            }
        }



        for (int i = 0; i < resultArray[0].length; i++) {
            System.out.println(resultArray[0][i]);
        }

        //Возвращаем наибольший результат
        System.out.println("Best value: " + resultArray[0][index]);


        switch (index) {
            case 0:
                return "Empty";
            case 1:
                return "Beagle";
            case 2:
                return "Blenheim_spaniel";
            case 3:
                return "Corgi";
            case 4:
                return "Dalmatian";
            case 5:
                return "German_shepherd";
            case 6:
                return "Huskies";
            case 7:
                return "Labrador";
            case 8:
                return "Shar_pei";
            default:
                return "Error";
        }
    }

    public float[] resizePic(String path) throws IOException {
        BufferedImage byteImage = ImageIO.read(new File(path)); //Грузим картинку
        //Меняем размер картинки на 512х512 так как это требует модель
        BufferedImage resizedImage = new BufferedImage(512, 512, BufferedImage.TYPE_INT_RGB);
        resizedImage.getGraphics().drawImage(byteImage, 0, 0, 512, 512, null); //Перерисовываем картинку
        //Преобразуем картинку в массив
        int[] pixels = resizedImage.getRGB(0, 0, 512, 512, null, 0, 512);
        //Преобразуем в float
        float[] floatPixels = new float[pixels.length * 3]; //3 канала (RGB) на каждый пиксель
        for (int i = 0; i < pixels.length; ++i) { //перебираем пиксели
            int pixel = pixels[i];
            floatPixels[i * 3] = (float) ((pixel >> 16) & 0xFF); //Red
            floatPixels[i * 3 + 1] = (float) ((pixel >> 8) & 0xFF); //Green
            floatPixels[i * 3 + 2] = (float) ((pixel) & 0xFF); //Blue
        }
        return floatPixels;
    }
    public SavedModelBundle init(){
         return SavedModelBundle.load("./src/main/resources/model", "serve");
    }
//    public static void main(String[] args) throws IOException {
//
//
////        public NeiroModel() throws IOException {
//            SavedModelBundle model = SavedModelBundle.load("./src/main/resources/model", "serve"); //Грузим модель
//            BufferedImage byteImage = ImageIO.read(new File("./src/main/resources/images/beagle.jpg")); //Грузим картинку
//            //Меняем размер картинки на 512х512 так как это требует модель
//            BufferedImage resizedImage = new BufferedImage(512, 512, BufferedImage.TYPE_INT_RGB);
//            resizedImage.getGraphics().drawImage(byteImage, 0, 0, 512, 512, null); //Перерисовываем картинку
//    //        //Сохраняем картинку в файл (проверка)
//    //        ImageIO.write(resizedImage, "jpg", new File("./src/main/resources/images/1_resized.jpg"));
//            //Преобразуем картинку в массив
//            int[] pixels = resizedImage.getRGB(0, 0, 512, 512, null, 0, 512);
//            //Преобразуем в float
//            float[] floatPixels = new float[pixels.length * 3]; //3 канала (RGB) на каждый пиксель
//            for (int i = 0; i < pixels.length; ++i) { //перебираем пиксели
//                int pixel = pixels[i];
//                floatPixels[i * 3] = (float) ((pixel >> 16) & 0xFF); //Red
//                floatPixels[i * 3 + 1] = (float) ((pixel >> 8) & 0xFF); //Green
//                floatPixels[i * 3 + 2] = (float) ((pixel) & 0xFF); //Blue
//            }
//            //Создаем тензор
//            Tensor<Float> tensor = Tensor.create(new long[]{1, 512, 512, 3}, FloatBuffer.wrap(floatPixels)); //1-количество картинок, 512-размер картинки, 3-количество каналов
//            //Получаем результат
//            Tensor<?> result = model.session().runner()
//                    .feed("serving_default_sequential_input:0", tensor) //Входной тензор
//                    .fetch("StatefulPartitionedCall:0") //Выходной тензор
//                    .run().get(0);
//            //Выводим результат в массив 1-9
//            float[][] resultArray = new float[1][9];
//            result.copyTo(resultArray);
//
//            HashMap<Integer, String> map = new HashMap<>();
//            map.put(0, ".ipynb_checkpoints");
//            map.put(1,"Beagle");
//            map.put(2,"Blenheim_spaniel");
//            map.put(3,"Corgi");
//            map.put(4,"Dalmatian");
//            map.put(5,"German_shepherd");
//            map.put(6,"Huskies");
//            map.put(7,"Labrador");
//            map.put(8,"Shar_pei");
//
////            //Найти наибольшее число в массиве
////            float max = 0;
////            int index = 0;
////            for (int i = 0; i < resultArray[0].length; i++) {
////                if (resultArray[0][i] > max) {
////                    max = resultArray[0][i];
////                    index = i;
////                }
////            }
////            System.out.println("Индекс наибольшего коэфф.: "+ index);
//        // return index;
//
//        HashMap<Float, String> newMap = new HashMap<>();
//        for (int i = 0; i < 9; i++) {
//            for (Map.Entry<Integer, String> hasVal : map.entrySet()) {
////                   for(int k = 0; k< 9; k++) {
////                   hasVal.getKey(k).toString();
////                   }
//
//                newMap.put(resultArray[0][i], hasVal.getValue());
//            }
//
//                //System.out.println(resultArray[0][i]);
//        }
////        newMap.entrySet().forEach(entry -> {
////            System.out.println(entry.getKey() + " " + newMap.values());
////        });
//        Map<Integer, String> swapped = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
//        System.out.println(newMap.entrySet());
//    }
////        }
}