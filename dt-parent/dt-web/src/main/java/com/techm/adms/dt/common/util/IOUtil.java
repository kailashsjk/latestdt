/**
 * 
 */
package com.techm.adms.dt.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <Comments Here>
 * 
 * @CreatedBy TechM
 * @CreatedOn 07-Oct-2015 10:44:28 am
 */
public final class IOUtil {

    /**
     * Member variable BUFFER_SIZE
     */
    private static final int BUFFER_SIZE = 2 * 1024 * 1024;

    /**
     * private constructor
     */
    private IOUtil() {

    }

    /**
     * @param input
     * @return
     * @throws IOException
     */
    public static byte[] convertInputStreamToOutputStream(final InputStream input) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] out = null;

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = input.read(buffer);
        while (bytesRead != -1) {
            bos.write(buffer, 0, bytesRead);
            bytesRead = input.read(buffer);
        }
        input.close();
        out = bos.toByteArray();
        return out;

    }
}
