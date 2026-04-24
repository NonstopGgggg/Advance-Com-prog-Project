# Advance-Com-prog-Project
A project for Advance Computer Programming course.

## Use Cases
A quick and reliable visual novel creator that help story tellers to envision their stories.
For example,
  1. A visual novel explaining math concepts
  2. A fantasy story with images

## About code
The code implements OCP and SRP principles for each classes.
The code also implement 4 design patterns as follow:
  1. Composite
  2. Factory
  3. Singleton
  4. Observer

# How to make a visual novel
The steps are as follow: 
##1. create a new folder and place it in the **same place** as Java Project folder.
##2. Inside the new folder, create two folders: Script and Image
##3. For Script folder, there can be **two main types (Normal and Route)** of text file placed here.

## Normal Text
A normal Text has **2** main components:
  1. The dialogue
  2. Next dialogue path

There can **3 main elements** included for each line of **the dialogue**:
  1. The speaker (optional)
  2. The message 
  3. The image (optional)
These elements are structured as follow: **Speaker: Message \image:Image Path**

The are **2 elements** in next dialogue path:
  1. Boolean (Does story continue)
     - TRUE for loading the next dialogue
     - FALSE for stopping the dialogue
  2. Path (where is the next dialogue)
These elements are structured as follow: **\Boolean\Path**

### Example
Jane: Hi... \image:Visual Noveler\Image\image1.jpg
Kalen: Sup! Since you just arrived, anything you wanna grab?
Jane: How gluttonous...
Kalen: ...
Jane: Ramen, I guess.
Kalen: Pfft...
Kalen: You said that yourself, yet you still suggest.
Kalen: How nostalgic.\image:Visual Noveler\Image\image2.jpg
Jane: Shio Ramen pls!
Kalen: Ahh! Me too.
Kalen: Just like when we were kids.
\TRUE\Visual Noveler\Script\Dialogue2.txt

## Route Text
A route text composed of **two text file**:
  1. Route indicator (Tell the program to handle the next text file as route file)
  2. Routes (Contain choices)

There can **2 main elements** included for each line of **Routes**:
  1. The message
  2. path
These elements are structured as follow: **Speaker: Message \image:Image Path**

The are 2 elements in next dialogue path:
  1. Boolean (Does story continue)
     - TRUE for loading the next dialogue
     - FALSE for stopping the dialogue
  2. Path (where is the next dialogue)
These elements are structured as follow \Boolean\Path

### Example
Jane: Hi... \image:Visual Noveler\Image\image1.jpg
Kalen: Sup! Since you just arrived, anything you wanna grab?
Jane: How gluttonous...
Kalen: ...
Jane: Ramen, I guess.
Kalen: Pfft...
Kalen: You said that yourself, yet you still suggest.
Kalen: How nostalgic.\image:Visual Noveler\Image\image2.jpg
Jane: Shio Ramen pls!
Kalen: Ahh! Me too.
Kalen: Just like when we were kids.
\TRUE\Visual Noveler\Script\Dialogue2.txt

### Route Text

### Common problems:
":" must be added after speaker to pinpoint where the name ends.

"\image" must be added before image to pinpoint that the following text is Image Path.

The program might not be able to display the correct image and text if the file is not found. Thus, check the path of your file to verify its integrity.
