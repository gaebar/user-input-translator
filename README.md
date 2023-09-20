# User Input Translator

## Overview

This project was developed as part of a TechBridge assignment while I was preparing for the Microsoft Azure AZ-900 certification. I decided to integrate the Azure Translator Text API to give a real-world application to the concepts I was learning. The goal was to create a small Java program that meets the following requirements as per the assignment prompt:

"Get Creative! Create a small program that takes user input using a scanner and any data type. Display the value input. Then, perform some type of manipulation on that value and display that result. Do your best to incorporate as many elements from the lesson. (Data types, Operators, Input, Output, and Comments.)"

To fulfill these requirements, this console application accepts text input from the user, along with the source and target language codes, and leverages the Azure Translator Text API to translate the text. The translated text is then displayed to the user.


## Objective Achievements

- **Data Types**: Utilized strings to handle text input and output.
- **Operators**: Implemented string manipulation operations.
- **Input**: Incorporated the Scanner class to obtain user inputs.
- **Output**: Utilized System.out.println to display results to the user.
- **Comments**: Included comments throughout the code to explain various sections and operations.

## Setup

1. Clone the repository: `git clone https://github.com/gaebar/user-input-translator.git`
2. Navigate to the project directory: `cd user-input-translator`
3. Open the project in your favorite IDE or text editor.
4. Set up the Azure Translator Text API according to the instructions in the 'Azure Setup' section.
5. Run the main method in the `TranslatorText` class to execute the program.

## Azure Setup

Before running the program, you need to set up the Azure Translator Text API:

1. Create an Azure account if you don't already have one.
2. Set up a Translator Text resource in the Azure portal, following the instructions provided in the Azure documentation.
3. Note down the API key and endpoint URL.
4. Update the `TranslatorText` class with your API key and endpoint URL.

## Usage

Upon running the program, follow the prompts to input text and select the source and target languages for translation. The program will then display the translated text.

## Contributing

Feel free to fork the repository and submit pull requests to contribute to this project. All contributions are welcome!

## License

This project is open-source and available under the MIT License.

