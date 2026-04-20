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

## How it work
This visual novel creator uses text file as the main input. 
There can **3 main elements** included in a single line:
  1. The speaker (optional)
  2. The message 
  3. The image (optional)
These elements are structured as follow: **Speaker: Message \image:Image Path**

### Common problems:
":" must be added after speaker to pinpoint where the name ends.

"\image" must be added before image to pinpoint that the following text is Image Path.

The program might not be able to display the correct image and text if the file is not found. Thus, check the path of your file to verify its integrity.
