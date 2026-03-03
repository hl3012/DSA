public class AmazonLockerSystem {
    //快递的box
    //第一步use case: 
    //deliver man deliver package
    //locker sent message to user
    //user pick up package by message code
    //return to sender 释放标记退回

    //high-level核心类

    public static class LockerUnit {
        private int locker_id;
        private int locker_size; // 1, 2, 3
        private boolean occupied;
    }

    public static class Package {
        private int package_id;
        private int package_size; // 1, 2, 3
        private String receverPhone;
        private String senderPhone;
    }

    








    //LockerUnit以系统为主体
    //-int locker_size  1, 2, 3 is size
    //-int locker_id
    //-boolean isOccupied
    
    //AmazonLockerSystem (int capacity)
    //-String delivermanPassword
    //-Map<Integer, List<LockerUnit>> sizeTolockerMapper=Map.of(1:{},2:{},3:{})   all lockers
    //-Map<Locker, Pacakge>  packageToLockerMapper={};
    //-int capacity
    //-boolean HandleDeliverPackage(DeliverPackageRequest request)
        //if(request.delivermanPassword==delivermanPassword) {
        //     check available lock unit
        //     for(int size: sizeTolockerMapper.keySet()) {
        //            if(size>=request.package.size) {
        //               List<LockerUnit>=sizeToLockerMapper.get(size)
          //                  for(currentLock ) check availabele 
          //                      if true, break, or currentLocker.isOccupied=true String code=UUID.random()
          //                       codeToLockerMapping.put(code, currLocker)
          //                        packageToLockerMapper.put(package,code)
          //                             break
        //            }
        //      }     
        //} else Throw Exception("Incorrect Password");
    //- boolean sent message(int phone, string packageInfo)
    //- handleRetrivePackage(RetrivePackageRequest request)
        //if codeToLockerMapping.containsKey(request.code)) {
        //            locker=codeToLockerMapping.get(code)    locker.isOccupied=false,  packageToLockerMapper.remove(locker) codeToLockerMapping.remobe(code)}

    //RetrivePackageRequest
    //-String code
    //

    //DeliverPackageRequest
    //-Package package
    //--String delivermanPassword

    //Deliveryman
    //-user_type
    //-user_id
    //-name

    //-小的占满了再用中的，再用大的

    //Package行李
    //-int package_size 1, 2, 3 size
    //-int package_id
    //-String sender
    //-String receiver
    //-int receiverPhone
}
