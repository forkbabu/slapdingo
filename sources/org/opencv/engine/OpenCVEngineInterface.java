package org.opencv.engine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface OpenCVEngineInterface extends IInterface {

    public static class Default implements OpenCVEngineInterface {
        public IBinder asBinder() {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public int getEngineVersion() throws RemoteException {
            return 0;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public String getLibPathByVersion(String str) throws RemoteException {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public String getLibraryList(String str) throws RemoteException {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public boolean installVersion(String str) throws RemoteException {
            return false;
        }
    }

    int getEngineVersion() throws RemoteException;

    String getLibPathByVersion(String str) throws RemoteException;

    String getLibraryList(String str) throws RemoteException;

    boolean installVersion(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements OpenCVEngineInterface {
        private static final String DESCRIPTOR = "org.opencv.engine.OpenCVEngineInterface";
        static final int TRANSACTION_getEngineVersion = 1;
        static final int TRANSACTION_getLibPathByVersion = 2;
        static final int TRANSACTION_getLibraryList = 4;
        static final int TRANSACTION_installVersion = 3;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static OpenCVEngineInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof OpenCVEngineInterface)) {
                return new Proxy(iBinder);
            }
            return (OpenCVEngineInterface) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int engineVersion = getEngineVersion();
                parcel2.writeNoException();
                parcel2.writeInt(engineVersion);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String libPathByVersion = getLibPathByVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(libPathByVersion);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean installVersion = installVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(installVersion ? 1 : 0);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                String libraryList = getLibraryList(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(libraryList);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements OpenCVEngineInterface {
            public static OpenCVEngineInterface sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public int getEngineVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEngineVersion();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public String getLibPathByVersion(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLibPathByVersion(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public boolean installVersion(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().installVersion(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public String getLibraryList(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLibraryList(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(OpenCVEngineInterface openCVEngineInterface) {
            if (Proxy.sDefaultImpl != null || openCVEngineInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = openCVEngineInterface;
            return true;
        }

        public static OpenCVEngineInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
