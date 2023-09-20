# User Input Translator

## Overview

This project was developed as part of a TechBridge assignment while preparing for the Microsoft Azure AZ-900 certification. I decided to utilize the Azure Translator Text API to provide a real-world application of the concepts studied during the course. The assignment tasked us with creating a small Java program that meets the criteria outlined in the prompt below:

"Get Creative! Create a small program that takes user input using a scanner and any data type. Display the value input. Then, perform some type of manipulation on that value and display that result. Do your best to incorporate as many elements from the lesson. (Data types, Operators, Input, Output, and Comments.)"

To fulfill these requirements, this console application accepts text input from the user, along with the source and target language codes, and leverages the Azure Translator Text API to translate the text. The translated text is then displayed to the user.

## Objective Achievements

- **Data Types**: Utilized strings to handle text input and output and primitive data types for temporary variable storage.
- **Operators**: Implemented string manipulation operations such as concatenation and methods to process the translation response.
- **Input**: Incorporated the Scanner class to facilitate user input.
- **Output**: Utilized System.out.println to display results, including translated text, to the user.
- **Comments**: Integrated comments throughout the code to clarify the function and purpose of various sections and operations.

## Setup

1. Clone the repository: `git clone https://github.com/gaebar/user-input-translator.git`
2. Navigate to the project directory: `cd user-input-translator`
3. Open the project in your preferred IDE or text editor.
4. Set up the Azure Translator Text API according to the instructions in the 'Azure Setup' section. You can find detailed instructions [here](Azure Documentation Link).
5. Run the main method in the `TranslatorText` class to initiate the program.

## Azure Setup

Before executing the program, ensure to set up the Azure Translator Text API:

1. Create an Azure account if not already available.
2. Establish a Translator Text resource in the Azure portal. Follow the guidelines provided in the [Azure documentation](Azure Documentation Link).
3. Record the API key and endpoint URL.
4. Update the `TranslatorText` class with your specific API key and endpoint URL, as described in the documentation.

## Usage

Run the program and adhere to the prompts to input text and designate the source and target languages for translation. Refer to the official documentation for a list of valid language codes. The program will then present the translated text.

## Contributing

Contributions are welcomed! Feel free to fork the repository and submit pull requests. We appreciate enhancements, bug fixes, and other contributions.

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).

