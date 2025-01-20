public class Studenttest {
    public static void main(String[] args){
        Student st1 = new Student();
        Student st2 = new Student();
        Student st3 = new Student();

        Student[] band = {st1, st2, st3};

        Student st4 = new Student();
        if(exist(band, st4.getId())){
            System.out.println("Can't join in band because this id exists");
        }
        else {
            Student[] newband = {st1,st2,st3,st4};
            traverseStudent(newband);

        }

    }

    public static boolean exist(Student[] arr, String id){
        for(int i =0; i<arr.length;i++){
            if(arr[i].getId()==id){
                return true;
            }
        }
        return false;
    }

    public static void traverseStudent(Student[] band){
        for (int i = 0; i < band.length; i++) {
            System.out.println(band[i].getId()+" "+band[i].getName()+" "+band[i].getAge());

        }
        System.out.println();
    }
}
