package com.ultrapower.rmi;

import com.ultrapower.bean.FileBean;
import com.ultrapower.bean.FileInfoBean;
import com.ultrapower.bean.FtpServerBean;
import com.ultrapower.bean.ProbeBean;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @ClassName com.ultrapower.rmi.ServerInterface
 * @Title dcs_server rmi接口服务客户端辅助类，必须与RMI接口服务端接口包名、类名、方法名完全一致，否则无法转化成功。
 * @Description
 * @Author fanjianfeng
 * @Version V1.0
 * @Created by   2018-06-06 17:58
 */
public interface ServerInterface extends Remote
{
    public abstract void insertFile(FileBean paramFileBean)
            throws RemoteException;

    public abstract void updateServer(FtpServerBean paramFtpServerBean)
            throws RemoteException;

    public abstract List<FtpServerBean> getServerList()
            throws RemoteException;

    public abstract FileInfoBean getFileInfo(ProbeBean paramProbeBean)
            throws RemoteException;

    public abstract void updateRate(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2)
            throws RemoteException;

    public abstract List<FileInfoBean> getTaskFileByProbeId(int paramInt)
            throws RemoteException;

    public abstract void heartbeat(ProbeBean paramProbeBean)
            throws RemoteException;

    public abstract FileInfoBean getHDFSFileInfo(ProbeBean paramProbeBean)
            throws RemoteException;
}
