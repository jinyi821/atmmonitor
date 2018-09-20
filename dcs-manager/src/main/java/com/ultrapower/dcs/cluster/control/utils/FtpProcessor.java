package com.ultrapower.dcs.cluster.control.utils;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.util.Map;

public interface FtpProcessor {

	Map<String,Object> process(FTPClient ftp) throws IOException ;
}
