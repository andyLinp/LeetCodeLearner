package com.learner.leetcodelearner.lib.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/9/25
 */
public class ImageUtils {


    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            // 读取原始图片
            BufferedImage image = ImageIO.read(new File("H:\\360MoveData\\Users\\Administrator\\Desktop\\img\\12333312.png"));

            // 计算新图片的宽度和高度
            int minX = image.getWidth();
            int minY = image.getHeight();
            int maxX = 0;
            int maxY = 0;

            // 遍历原始图片的每个像素
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    // 获取当前像素的颜色
                    Color color = new Color(image.getRGB(x, y), true);
                    // 黑色 0 0 0
                    // 如果当前像素的 alpha 值大于 0（即不透明），更新新图片的宽度和高度
                    if (color.getAlpha() > 0) {
                        minX = Math.min(minX, x);
                        minY = Math.min(minY, y);
                        maxX = Math.max(maxX, x);
                        maxY = Math.max(maxY, y);
                    }
                }
            }

            // 计算新图片的宽度和高度
            int newWidth = maxX - minX + 1;
            int newHeight = maxY - minY + 1;

            // 创建一个新的 BufferedImage
            BufferedImage result = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

            // 复制非透明区域到新图片中
            for (int y = minY; y <= maxY; y++) {
                for (int x = minX; x <= maxX; x++) {
                    Color color = new Color(image.getRGB(x, y), true);
                    result.setRGB(x - minX, y - minY, color.getRGB());
                }
            }
            OutputStream fop = new FileOutputStream(new File("H:\\360MoveData\\Users\\Administrator\\Desktop\\img\\output3.png"));
            // 保存去除透明区域后的图片
            ImageIO.write(result, "png", fop);

            System.out.println("透明区域已去除并保存为 output.png");
            long end = System.currentTimeMillis();
            System.out.println("用时:" + (end - start));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
