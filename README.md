# safe

⚠️ **Important Note: This library is currently under development and should not be used in
production environments yet. Use it at your own risk.**

[![Java Version](https://img.shields.io/badge/java-%3E%3D%2020%20(enabled--preview)-blue.svg)](https://www.java.com/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Introduction

safe is a small Java library designed to provide a more efficient and concise way to access
references. It offers a simple and expressive syntax to handle nullable or optional references in a
more streamlined manner, reducing the need for boilerplate code and potential null pointer
exceptions.

## Features

- Provides a fluent API for accessing references in a safe and efficient way.
- Simplifies handling of nullable or optional references.
- Reduces boilerplate code and potential null pointer exceptions.
- Supports Java 20 (enabled preview) or higher.

## Usage

```java
import dev.orhantugrul.safe.Ref;
import dev.orhantugrul.safe.Maybe.Just;
import dev.orhantugrul.safe.Maybe.Nothing;

class Main {
  public static void main(final String[] args) {
    final var happyReference = switch (Ref.from(null)) {
      case Just(final var value) -> value;
      case Nothing() -> throw new AssertionError("There is no value :/");
    };
  }
}
```

## Contributing

Contributions to safe are welcome! If you would like to contribute, please follow these steps:

- Fork the repository and clone it to your local machine.
- Create a new branch for your feature or bug fix.
- Make your changes and commit
  them, [following the conventional commit message format.](https://www.conventionalcommits.org/en/v1.0.0/)
- Push your changes to your forked repository.
- Submit a pull request to the `main` branch of the original repository.

Please ensure that your code adheres to the existing coding style and that you have added
appropriate tests for your changes.

## License

safe is open-source software licensed under the [MIT License](https://opensource.org/license/mit/).
Feel free to use, modify, and distribute it as outlined in the license.