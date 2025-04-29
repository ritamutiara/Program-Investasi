<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <header>
        <h1><strong>Program Investasi</strong></h1>
    </header>
  
  <div>
        <p>Halo! Program ini kami rancang untuk menyelesaikan tugas dari mata kuliah PBO (Pemrograman Berbasis Objek) kami.</p>

  <div>
            <h3>Perkenalkan kami:</h3>
            <ul>
                <li><strong>Ni Made Rita Mutiara Dewi</strong> (2405551009 || PBO B)</li>
                <li><strong>Putu Lidya Paramita Sunu</strong> (2405551075 || PBO B)</li>
            </ul>
        </div>

  <p>Program ini adalah aplikasi investasi sederhana berbasis command line yang memungkinkan pengguna melakukan investasi saham dan Surat Berharga Negara (SBN). Program ini menggunakan bahasa pemrograman Java yang dirancang untuk dua jenis user dengan akses yang berbeda, yaitu:</p>
        <ol>
            <li><strong>Admin</strong> diberikan akses untuk melihat semua portofolio, memperbarui data saham, dan mengelola SBN.</li>
            <li><strong>Customer</strong> diberikan akses untuk melihat portofolio mereka, membeli/menjual saham, dan membeli SBN.</li>
        </ol>
        <p>Program ini juga dilengkapi dengan input validasi untuk memastikan pengguna memberikan input yang sesuai dengan yang dibutuhkan oleh program.</p>

  <p>Berikut uraian sistem, cara kerja, dan diagram UML yang telah dilengkapi komentar untuk mempermudah pemahaman alur pemakaian program. Silakan disimak!</p>
    </div>

   <div>
        <h2><strong>UML</strong></h2>
        <div>
            <img src="assets/002.png" alt="Diagram UML program investasi" />
        </div>
    </div>

  <div>
        <h2><strong>TEORI PADA PROGRAM INVESTASI</strong></h2>
        <p>Program investasi mengimplementasikan prinsip-prinsip Object Oriented Programming (OOP) sebagai berikut.</p>
        
   <ol>
            <li>
                <h3><strong>Kelas dan Objek</strong></h3>
                <p>Program ini menggunakan kelas untuk mendefinisikan entitas seperti Saham, User, Admin, dan Customer, yang masing-masing memiliki atribut dan perilaku tertentu. Sedangkan, objek adalah instansi dari kelas-kelas ini yang digunakan untuk berinteraksi dengan data dalam program.</p>
            </li>
            
   <li>
                <h3><strong>Pewarisan (<em>Inheritance</em>)</strong></h3>
                <p>Admin dan Customer mewarisi atribut dan metode dasar dari kelas User, memungkinkan keduanya berbagi fitur umum namun tetap dapat menambahkan fungsionalitas khusus untuk masing-masing tipe pengguna.</p>
            </li>
            
  <li>
                <h3><strong>Polimorfisme (<em>Polymorphism</em>)</strong></h3>
                <p>Polimorfisme memungkinkan objek dari kelas turunan (Admin dan Customer) diperlakukan sebagai objek kelas induk (User), yang mempermudah proses seperti login yang sama untuk semua tipe pengguna, meskipun ada perbedaan perilaku.</p>
            </li>
            
  <li>
                <h3><strong>Abstraksi (<em>Abstraction</em>)</strong></h3>
                <p>Program menyembunyikan detail implementasi dengan menyediakan antarmuka sederhana yang hanya menampilkan fungsionalitas penting, seperti metode untuk menambah saham atau membeli SBN tanpa perlu tahu bagaimana proses tersebut dikelola di dalam kelas.</p>
            </li>
            
  <li>
                <h3><strong>Enkapsulasi (<em>Encapsulation</em>)</strong></h3>
                <p><em>Encapsulation</em> membatasi akses langsung ke data internal dan hanya memungkinkan perubahan melalui metode getter dan setter, menjaga data tetap aman dan terkontrol.</p>
            </li>
            
   <li>
                <h3><strong>Komposisi (<em>Composition</em>)</strong></h3>
                <p>Komposisi terlihat ketika objek Transaksi berisi objek lain seperti Saham atau SBN, yang menunjukkan hubungan antara transaksi dan entitas terkait yang terlibat dalam investasi.</p>
            </li>
            
   <li>
                <h3><strong><em>Overloading</em></strong></h3>
                <p>Metode seperti tambahSaham() di kelas SahamFitur menggunakan overloading, di mana metode yang sama dapat memiliki parameter yang berbeda untuk fleksibilitas dalam menambahkan saham dengan cara yang lebih beragam.</p>
            </li>
            
  <li>
                <h3><strong>Penggunaan Koleksi (<em>Collections</em>)</strong></h3>
                <p>ArrayList digunakan untuk menyimpan dan mengelola daftar objek seperti Saham, SBN, dan Transaksi, yang memungkinkan pengelolaan data yang lebih dinamis dan fleksibel.</p>
            </li>
            
  <li>
                <h3><strong>Flow Control</strong></h3>
                <p>Flow control dalam program investasi digunakan untuk mengendalikan jalannya program dan mengarahkan alur program berdasarkan kondisi atau input yang diberikan oleh pengguna.</p>
            </li>
        </ol>
    </div>

  <div>
        <h2><strong>ALUR PEMAKAIAN PROGRAM</strong></h2>
        <p>Berikut cara penggunaan program investasi beserta tampilan hasil eksekusi programnya. Petunjuk penggunaan disertakan untuk memandu pengguna.</p>

  <div>
            <p>Pertama, saat aplikasi dijalankan, akan muncul layar login. Silakan pilih 1 untuk login atau 0 untuk logout.</p>
            <div>
                <p><strong>Catatan</strong>: Untuk login sebagai admin, gunakan username: "admin" dan password: "admin123". Untuk customer, gunakan username: "customer" dan password: "customer123"</p>
            </div>
                <img src="assets/01.png" alt="Tampilan layar login aplikasi" />
            <div>
                <img src="assets/02.png" alt="Tampilan proses login aplikasi" />
            </div>
                <img src="assets/03.png" alt="Tampilan setelah berhasil login" />
        </div>

  <h1><strong>Sebagai Admin</strong></h1>
        <img src="assets/04.png" alt="Tampilan menu utama admin" />
        
  <div>
            <p>Di menu Admin, Anda sebagai admin memiliki tiga pilihan yaitu:</p>
            <ul>
                <li><strong>Pilihan 1</strong>: Masuk ke menu Pengelolaan Saham</li>
                <li><strong>Pilihan 2</strong>: Masuk ke menu Pengelolaan Surat Berharga Negara</li>
                <li><strong>Pilihan 3</strong>: Keluar dari akun admin</li>
            </ul>
            <img src="assets/05.png" alt="Tampilan pilihan menu admin" />
        </div>

  <div>
            <p>Jika Anda memilih angka 1 pada menu Admin, Anda akan masuk ke menu Pengelolaan Saham.</p>
            <img src="assets/06.png" alt="Tampilan menu pengelolaan saham" />
            
  <p>Pilih angka 1 untuk menambahkan saham baru ke dalam sistem. Anda akan diminta memasukkan informasi saham. Sistem akan memproses permintaan Anda dan menampilkan pesan konfirmasi bahwa saham berhasil ditambahkan.</p>
            <img src="assets/07.png" alt="Tampilan form tambah saham" />
            
  <p>Jika Anda memilih angka 2 pada menu Admin, Anda akan masuk ke menu Pengelolaan Harga Saham untuk mengubah harga saham.</p>
            <img src="assets/08.png" alt="Tampilan menu ubah harga saham" />
            
  <p>Sistem akan menampilkan daftar saham yang tersedia pada program.</p>
    <img src="assets/09.png" alt="Tampilan daftar saham" />
            
  <p>Kemudian, Anda diminta untuk memasukkan kode saham yang akan diperbarui dan harga barunya. Jika proses berhasil, Anda akan melihat pesan bahwa harga saham berhasil diubah menjadi harga barunya.</p>
            <img src="assets/10.png" alt="Tampilan konfirmasi perubahan harga" />
        </div>

  <div>
            <p>Jika Anda memilih angka 2 dari menu Admin, Anda akan masuk ke menu Pengelolaan SBN.</p>
            <img src="assets/11.png" alt="Tampilan menu pengelolaan SBN" />
            
  <p>Pilih angka 1 untuk menambahkan SBN baru ke dalam sistem.</p>
            <img src="assets/12.png" alt="Tampilan form tambah SBN" />
            
  <p>Anda akan diminta memasukkan informasi SBN. Setelah informasi diproses, sistem akan menampilkan pesan konfirmasi bahwa SBN yang baru telah berhasil ditambahkan.</p>
            <img src="assets/13.png" alt="Tampilan konfirmasi tambah SBN" />
        </div>

<div>
            <p>Untuk keluar dari mode admin, pilih angka 3 dari menu Admin.</p>
        </div>

  <h1><strong>Sebagai Customer</strong></h1>
        <img src="assets/14.png" alt="Tampilan menu utama customer" />
        
  <div>
            <p>Di menu Customer, Anda sebagai Customer memiliki tujuh pilihan sebagai berikut:</p>
            <ul>
                <li><strong>Pilihan 1</strong>: Masuk ke menu Beli Saham untuk membeli saham yang tersedia di pasar.</li>
                <li><strong>Pilihan 2</strong>: Masuk ke menu Jual Saham untuk menjual saham yang Anda miliki.</li>
                <li><strong>Pilihan 3</strong>: Masuk ke menu Beli SBN untuk membeli Surat Berharga Negara (SBN) yang tersedia.</li>
                <li><strong>Pilihan 4</strong>: Masuk ke menu Simulasi SBN untuk menghitung estimasi keuntungan dari investasi SBN.</li>
                <li><strong>Pilihan 5</strong>: Lihat Portofolio untuk melihat daftar saham dan SBN yang Anda miliki serta total nilai investasi.</li>
                <li><strong>Pilihan 6</strong>: Lihat Riwayat Transaksi untuk melihat daftar transaksi yang telah Anda lakukan, baik untuk saham maupun SBN.</li>
                <li><strong>Pilihan 7</strong>: Logout untuk keluar dari akun Anda dan kembali ke layar login.</li>
            </ul>
            <img src="assets/15.png" alt="Tampilan menu pilihan customer" />
        </div>

  <div>
            <p>Jika Anda memilih angka 1 pada menu Customer, Anda akan masuk ke menu Beli Saham. Pada menu ini Anda dapat melihat daftar saham yang tersedia untuk dibeli, memilih saham yang diinginkan, dan memasukkan jumlah lembar saham yang ingin dibeli.</p>
            <img src="assets/16.png" alt="Tampilan menu beli saham" />
            
   <p>Setelah memilih saham yang diinginkan, Anda akan diminta untuk memasukkan kode saham dan jumlah lembar saham yang ingin Anda beli. Jika stok saham cukup, transaksi akan diproses dan saham yang Anda beli akan ditambahkan ke portofolio Anda. Jika transaksi berhasil, Anda akan menerima konfirmasi bahwa saham berhasil dibeli.</p>
            <img src="assets/17.png" alt="Tampilan konfirmasi beli saham" />
        </div>

  <div>
            <p>Jika Anda memilih angka 2 pada menu Customer, Anda akan masuk ke menu Jual Saham.</p>
            <img src="assets/18.png" alt="Tampilan menu jual saham" />
            
  <p>Kemudian, Anda akan diminta untuk memilih saham yang ingin dijual dari portofolio Anda.</p>
            <img src="assets/19.png" alt="Tampilan pilih saham untuk dijual" />
            
  <p>Setelah memilih saham, masukkan kode saham dan jumlah lembar yang ingin dijual. Jika transaksi berhasil, saham yang dijual akan dihapus dari portofolio Anda dan Anda akan menerima konfirmasi penjualan berhasil.</p>
            <img src="assets/20.png" alt="Tampilan konfirmasi jual saham" />
        </div>

<div>
            <p>Jika Anda memilih angka 3 pada menu Customer, Anda akan masuk ke menu Beli SBN.</p>
            <img src="assets/21.png" alt="Tampilan menu beli SBN" />
            
  <p>Anda akan diminta untuk memilih Surat Berharga Negara (SBN) yang ingin dibeli dari daftar yang tersedia.</p>
            <img src="assets/22.png" alt="Tampilan pilih SBN" />
            
  <p>Setelah memilih SBN, masukkan nominal pembelian yang diinginkan. Jika pembelian berhasil, Anda akan menerima konfirmasi bahwa pembelian SBN telah dilakukan dan nominal investasi Anda akan diperbarui.</p>
            <img src="assets/23.png" alt="Tampilan konfirmasi beli SBN" />
        </div>

  <div>
            <p>Jika Anda memilih angka 4 pada menu Customer, Anda akan masuk ke menu Simulasi SBN.</p>
            <img src="assets/24.png" alt="Tampilan menu simulasi SBN" />
            
  <p>Anda akan diminta untuk memilih Surat Berharga Negara (SBN) dari daftar yang tersedia. Setelah memilih SBN, masukkan nominal investasi yang ingin disimulasikan.</p>
            <img src="assets/25.png" alt="Tampilan input simulasi SBN" />
            
   <p>Sistem kemudian akan menghitung dan menampilkan estimasi hasil investasi berdasarkan bunga dan jangka waktu yang berlaku untuk SBN yang dipilih.</p>
            <img src="assets/26.png" alt="Tampilan hasil simulasi SBN" />
        </div>

  <div>
            <p>Jika Anda memilih angka 5 pada menu Customer, Anda akan masuk ke menu Portofolio.</p>
            <img src="assets/27.png" alt="Tampilan menu portofolio" />
            
   <p>Pada Portofolio Anda dapat melihat daftar kepemilikan saham dan SBN yang telah Anda beli, lengkap dengan jumlah lembar saham atau nominal investasi, nilai saat ini, serta estimasi keuntungan atau kerugian. Menu ini memberikan gambaran menyeluruh tentang aset investasi Anda di program.</p>
            <img src="assets/28.png" alt="Tampilan detail portofolio" />
        </div>

 <div>
            <p>Jika Anda memilih angka 6 pada menu Customer, Anda akan masuk ke menu Riwayat Transaksi.</p>
            <img src="assets/29.png" alt="Tampilan menu riwayat transaksi" />
            
  <p>Di dalamnya terdapat tiga pilihan:</p>
            <ul>
                <li><strong>Pilihan 1</strong>: Lihat semua transaksi</li>
                <li><strong>Pilihan 2</strong>: Cari transaksi berdasarkan kode</li>
                <li><strong>Pilihan 3</strong>: Logout</li>
            </ul>
            <img src="assets/30.png" alt="Tampilan pilihan riwayat transaksi" />
            
   <p>Jika Anda memilih angka 1 pada menu Riwayat Transaksi, Anda akan masuk ke menu Lihat Semua Transaksi.</p>
            <img src="assets/31.png" alt="Tampilan menu lihat semua transaksi" />
            <img src="assets/32.png" alt="Tampilan contoh riwayat transaksi" />
            
 <p>Jika Anda memilih angka 1 pada menu Riwayat Transaksi, semua riwayat transaksi Anda akan ditampilkan. Ini mencakup pembelian dan penjualan saham maupun pembelian SBN yang pernah Anda lakukan.</p>
            <img src="assets/33.png" alt="Tampilan semua transaksi" />
            
  <p>Jika Anda memilih angka 2 pada menu Riwayat Transaksi, Anda akan masuk ke menu Cari Transaksi Berdasarkan Kode.</p>
            <img src="assets/34.png" alt="Tampilan menu cari transaksi" />
            
  <p>Anda akan diminta memasukkan kode saham atau nama SBN. Setelah itu, program akan menampilkan riwayat transaksi yang sesuai dengan kode atau nama yang Anda cari.</p>
            <img src="assets/35.png" alt="Tampilan hasil pencarian transaksi" />
            
  <p>Jika Anda memilih angka 3 pada menu Riwayat Transaksi, Anda akan kembali ke menu Customer.</p>
            <img src="assets/36.png" alt="Tampilan kembali ke menu customer" />
        </div>

  <div>
            <p>Untuk keluar dari mode customer, pilih angka 7 dari menu Customer.</p>
        </div>
    </div>
</body>
</html>
