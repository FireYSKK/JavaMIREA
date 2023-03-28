public class Student {
    private int iDNumbers;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int iDNumbers, int score) {
        setiDNumbers(iDNumbers);
        setScore(score);
    }

    public int getiDNumbers() {
        return iDNumbers;
    }

    public void setiDNumbers(int iDNumbers) {
        this.iDNumbers = iDNumbers;
    }

    @Override
    public String toString(){
        return "id: "+iDNumbers+"\tscore: "+score;
    }
}
