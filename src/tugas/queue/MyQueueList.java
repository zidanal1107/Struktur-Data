package tugas.queue;

// Untuk menyimpan data yang akan digunakan di Queue
class Node<T> {
    T data;
    Node<T> next; // Untuk menghubungkan data
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MyQueueList<T> {
    int size; // Untuk jumlah data yang ada di Queue
    Node<T> head; // Untuk yang pertama kali masuk
    Node<T> tail; // Untuk yang terakhir kali

    // Inisialisasi awal
    public MyQueueList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return size;
    } // Mengambil nilai size

    public boolean isEmpty() {
        return size == 0;
    } // Mengecek apakah Queue kosong

    // Menambahkan data
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data); // Tambah data
        if (isEmpty()) {
            head = tail = newNode; // Jika Queue masih kosong buat data baru menjadi head dan tail
        } else { // Jika tidak kosong
            tail.next = newNode; // Tail next di ubah menjadi data baru
            tail = newNode; // dan data baru menjadi tail
        }
        size++; // Ukuran ditambah 1
    }

    // Mengambil data yang pertama kali masuk
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty"); // Jika Kosong lempar ke error runtime
        } // Jika tidak
        T data = head.data; // Head data akan disimpan ke variabel data
        head = head.next; // head di ganti dengan head next
        size--; // size dikurangi 1
        return data; // mengembalikan nilai data
    }

    // Memunculkan data
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty"); // jika kosong maka munculkan ini
            return;
        } // jika tidak
        Node<T> current = head; // buat variabel current adalah head
        while (current != null) { // data current tidak boleh bernilai null
            System.out.print(current.data+" "); // munculkan data yang ada di current
            current=current.next; // mengganti current dengan current selanjutnya
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Deklarasi object
        MyQueueList<String> CC1 = new MyQueueList<>();
        MyQueueList<String> CC2 = new MyQueueList<>();
        MyQueueList<String> CC3 = new MyQueueList<>();

        System.out.println("=== Antrean CC1 ===");
        System.out.print("Masuk: ");
        CC1.enqueue("11001"); // data yang masuk 11001
        CC1.print();

        System.out.print("Masuk: ");
        CC1.enqueue("11011"); // ditambah lagi 11011
        CC1.print();

        System.out.print("Layani: ");
        System.out.println(CC1.dequeue()); // diambil yang pertama kali masuk
        CC1.print();

        System.out.print("Masuk: ");
        CC1.enqueue("11123"); // ditambah 1123
        CC1.print();

        System.out.print("Masuk: ");
        CC1.enqueue("11015"); // ditambah 11015
        CC1.print();

        System.out.print("Layani: ");
        System.out.println(CC1.dequeue()); // diambil yang prtama kali masuk
        CC1.print();

        System.out.print("Masuk: ");
        CC1.enqueue("11331"); // ditambah 11331
        CC1.print();

        System.out.println("=== Antrean CC2 ===");
        System.out.print("Masuk: ");
        CC2.enqueue("11011"); // ditambah 11011
        CC2.print();

        System.out.print("Layani: ");
        System.out.println(CC2.dequeue()); // diambil yang pertama kali masuk
        CC2.print();

        System.out.print("Masuk: ");
        CC2.enqueue("11321"); // ditambah 11321
        CC2.print();

        System.out.print("Masuk: ");
        CC2.enqueue("11250"); // ditambah 11250
        CC2.print();

        System.out.print("Masuk: ");
        CC2.enqueue("11890"); // ditambah 11890
        CC2.print();

        System.out.print("Masuk: ");
        CC2.enqueue("11765"); // ditambah 11765
        CC2.print();

        System.out.print("Layani: ");
        System.out.println(CC2.dequeue()); // diambil ynag pertama kali masuk
        CC2.print();

        System.out.println("=== Antrean CC3 ===");
        System.out.print("Masuk: ");
        CC3.enqueue("11543"); // ditambah 11543
        CC3.print();

        System.out.print("Masuk: ");
        CC3.enqueue("11632"); // ditambah 11632
        CC3.print();

        System.out.print("Layani: ");
        System.out.println(CC3.dequeue()); // diambil yang pertama kali masuk
        CC3.print();

        System.out.print("Layani: ");
        System.out.println(CC3.dequeue()); // diambil yang pertama kali masuk
        CC3.print();

        System.out.print("Masuk: ");
        CC3.enqueue("11387"); // ditambah 11387
        CC3.print();

        System.out.print("Masuk: ");
        CC3.enqueue("11289"); // ditambah 11289
        CC3.print();

        System.out.print("Layani: ");
        System.out.println(CC3.dequeue()); // diambil yang pertama kali masuk
        CC3.print();

    }
}