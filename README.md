# Snake Game

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran.

[Challenge Guidelines](challenge-guideline.md)

**Implementasi dari game terkenal yaitu Snake dimana ada seekor ular yang dapat diarahkan untuk memakan buah. Dan jika ular tersebut memakan buah, panjangnya akan bertambah. Selain itu, terdapat aturan bila ular menyentuh batas frame atau tubuhnya sendiri, maka permainan selesai**

## Credits

| NPM          | Name                      |
| ------------ | ------------------------- |
| 140810210001 | Oriex Mawan Junnior       |
| 140810210003 | Muhammad Ikhsan Fadhilah  |
| 140810210037 | Qurrota Ayuni Qamra Ariva |

## Change log

- **[Sprint Planning](changelog/sprint-planning.md) - (21/11/2022)**

  - Diskusi awal perencanaan pembuatan game snake
  - Mencari referensi untuk membuat project
  - Penambahan challenge guideline

- **[Sprint 1](changelog/sprint-1.md) - (16/11/2022 - 21/11/2022)**

  - Menentukan kebutuhan dasar project (Gradle dan JavaFX)
  - Menentukan ukuran ular dan buah
  - Menentukan ukuran board dan cell
  - Menentukan posisi ular dan buah

- **[Sprint 2](changelog/sprint-2.md) - (22/11/2022 - 28/11/2022)**
  - Menentukan kecepatan ular
  - Menentukan refresh rate
  - Membuat aturan kontrol keyboard
  - Mengatur logika permainan terhadap seluruh sisi board dan bagian tubuh ular serta score permainan
  - Membuat tampilan menu dan isinya
- **[Sprint 3](changelog/sprint-3.md) - (29/11/2022 - 06/12/2022)**
  - Membuat leaderboard 10 skor tertinggi
  - Menambahkan fitur ubah level game
  - Membuat UML
  - Penyelesaian bug
  - Merapihkan interface program

## Running The App

1. Masuk ke direktori app (Folder app)

```
 contoh : cd ~/project-akhir-uas-pbo-2022-kelompok-a-11/app
```

2. Jalankan program dengan perintah :

```
 ./gradlew run
```

3. Tombol pada keyboard yang digunakan pada program :
   - Gunakan tombol `Up Arrow` , `Right Arrow` , `Down Arrow` , dan `Left Arrow` untuk mengarahkan ular atau gunakan tombol `W` , `A` , `S` , dan `D` untuk mengarahkan ular.
   - Gunakan mouse untuk navigasi pada menu utama dan mengubah level pada menu level.

## Classes Used

`App.java`

- Program utama yang berisi method main
  - 24 Class Variable
    - **@frame** - Ukuran frame dari program
    - **@engine** - Status setiap state pada program
    - **@keyboardListener** - Key untuk mengarahkan ular pada permainan
    - **@draw** - Draw setiap komponen pada permainan
    - **@snake** - Komponen ular pada permainan
    - **@fruit** - Komponen buah pada permainan
    - **@playerGame** - Pemain pada setiap permainan dijalankan
    - **@menu** - Scene menu utama pada program
    - **@level** - Scene menu level untuk mengubah level game
    - **@leaderboard** - Scene menu leaderboard untuk menampilkan skor dan nama setiap pemain
    - **@mainStage** - Stage untuk scene menu utama, level, dan leaderboard
    - **@scoreStage** - Stage pop-up untuk input nama pemain pada akhir permainan
    - **@startBtn** - Button untuk memulai permainan
    - **@leaderboardBtn** - Button untuk menampilkan leaderboard
    - **@levelBtn** - Button untuk masuk ke menu ubah level
    - **@easyBtn** - Button untuk memilih level easy
    - **@mediumBtn** - Button untuk memilih level medium
    - **@hardBtn** - Button untuk memilih level hard
    - **@backBtn** - Button untuk kembali ke scene sebelumnya
    - **@okBtn** - Button untuk konfirmasi input nama pada akhir permainan
    - **@exitBtn** - Button untuk save leaderboard dan keluar dari program
    - **@scoreNameField** - Input field pada pop-up untuk nama pemain
    - **@css** - Styling css yang digunakan pada program
    - **@playerList** - List pemain pada leaderboard
  - 9 Method
    - **@mainMenu()** - Menampilkan menu utama
    - **@level()** - Menampilkan menu level
    - **@readLeaderboard()** - Membaca data pada leaderboard dari external file
    - **@writeLeaderboard()** - Menyimpan data leaderboard ke external file
    - **@showLeaderboard()** - Menampilkan leaderboard
    - **@startGame()** - Memulai permainan baru
    - **@stopGame()** - Menghentikan permainan
    - **@buttonClicked()** - Mengatur action saat suatu button diklik
    - **@start()** - Menjalankan program utama

`Cell.java`

- Kelas untuk membuat suatu baris dalam ListView
  - 2 Class Variable
    - **@x** - Koordinat x
    - **@y** - Koordinat y
  - 1 Method
    - **@Cell()** - Set koordinat x,y

`Direction.java`

- Kelas Enum penentu arah gerak uar
  - 1 Method
    - **@Direction()** - berisi 4 arah gerak (UP, DOWN, RIGHT, LEFT)

`Draw.java`

- Kelas untuk menggambar komponen dengan grafik
  - 9 Method
    - **@drawBackground()** - Warna background untuk area permainan
    - **@drawSnake()** - Gambar ular
    - **@setSnakeColor()** - Atur warna dan gambar ular
    - **@moveSnake()** - Gambar pergerakan ular
    - **@increaseSnakeLength()** - Perpanjangan ular setelah memakan buah
    - **@invalidSnakeMove()** - Game over saat ular menyentuh badan sendiri
    - **@drawFruit()** - Gambar buah dengan warna random
    - **@drawPlayerScore()** - Menampilkan skor pemain
    - **@drawAllComponents()** - Gambar semua komponen

`Engine.java`

- Kelas boolean penentu kondisi dalam game
  - 3 Class Variable
    - **@isInGame** - Kondisi bermain
    - **@isGameOver** - Kondisi game over
    - **@isInMenu** - Kondisi di menu
  - 7 Method
    - **@Engine()** - Konstruktor
    - **@setIsInMenu()** - Setter kondisi di menu
    - **@setIsInGame()** - Setter kondisi bermain
    - **@setGameOver()** - Setter kondisi game over
    - **@getIsInGame()** - Getter kondisi bermain
    - **@getIsInMenu()** - Getter kondisi di menu
    - **@getIsGameOver()** - Getter kondisi game over

`Board.java`

- Kelas yang mengatur ukuran Frame aplikasi
  - 3 Class Variable
    - **@width** - lebar
    - **@height** - tinggi
    - **@cellSize** - Ukuran setiap sel di dalam area permainan
  - 4 Method
    - **@Frame()** - Konstruktor
    - **@getWidth()** - Getter lebar
    - **@getHeight()** - Getter tinggi
    - **@getCellSize()** - Getter ukuran

`Fruit.java`

- Kelas buah
  - 4 Class Variable
    - **@color** - Warna buah
    - **@x** - Koordinat x
    - **@y** - Koordinat y
    - **@rand** - Random warna buah
  - 8 Method
    - **@Fruit()** - Konstruktor
    - **@newFruit()** - Memunculkan buah
    - **@setColor()** - Setter warna
    - **@getColor()** - Getter warna
    - **@setX()** - Setter x
    - **@setY()** - Setter y
    - **@getX()** - Getter x
    - **@getY()** - Getter y

`KeyboardListener.java`

- Kelas kemudi ular menggunakan keyboard
  - 1 Method
    - **@listenKey()** - Kemudi ular menggunakan WASD atau Tombol Panah

`Player.java`

- Kelas pemain
  - 2 Class Variable
    - **@name** - Nama pemain
    - **@score** - Skor pemain
  - 6 Method
    - **@Player()** - Konstruktor
    - **@Player()** - Konstruktor
    - **@setName()** - Setter nama
    - **@incrementScore()** - Penambah skor
    - **@getName()** - Getter nama
    - **@getScore()** - Getter skor

`Snake.java`

- Kelas ular
  - 3 Class Variable
    - **@speed** - Kecepatan ular
    - **@bodyCells** - Badan ular
    - **@curDirection** - Arah ular
  - 6 Method
    - **@Snake()** - Konstruktor
    - **@setSpeed()** - Setter kecepatan
    - **@getSpeed()** - Getter kecepatan
    - **@getBodySize()** - Getter ukuran badan ular
    - **@setDirection()** - Setter arah
    - **@getCurDirection()** - Setter arah saat ini

UML image here

![UML](uml/SnakeUML.drawio.png "UML")

## Notable Assumption and Design App Details

- Desain Program
  - Program memiliki ukuran Board sebesar 600x450
  - Warna ular, buah, dan area permainan telah diatur dengan ketentuan yang telah ditetapkan
  - Perolehan skor akan bertambah sebanyak 1 setiap ular memakan buah
  - Terdapat menu untuk menampilkan pilihan memulai permainan, ubah level permainan (easy, medium, hard), leaderboard skor pemain, dan keluar dari program
  - Tombol-tombol yang digunakan adalah arrow keys atau WASD dan mouse untuk navigasi pada menu
  - Ular berukuran awal 5 sel akan muncul ditengah area permainan dengan menghadap ke kiri
  - Buah berukuran 1 sel akan muncul pada area secara random dengan aturan yang sudah ditetapkan
  - Jika Ular menyentuh setiap batas frame, maka permainan dinyatakan selesai
  - Jika Ular menyentuh tubuhnya sendiri, maka permainan juga dinyatakan selesai
  - Saat permainan selesai, program akan meminta nama dari user sesuai skor yang didapat
  - Skor yang telah didapat setiap pemain dapat dilihat pada menu leaderboard
  - Bila ingin menyimpan data-data pada leaderboard, pilih save & exit saat keluar dari program (Data pada leaderboard tidak otomatis tersimpan saat keluar dari program)
