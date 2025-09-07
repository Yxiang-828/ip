JAVA CODING STANDARDS - ESSENTIAL RULES

NAMING CONVENTIONS
- Packages: all lowercase (com.company.application.ui)
- Classes/Enums: PascalCase (AudioSystem)
- Variables: camelCase (audioSystem)
- Constants: SCREAMING_SNAKE_CASE (MAX_ITERATIONS)
- Methods: camelCase verbs (getName(), computeTotalWidth())
- Booleans: use prefixes (isSet, hasData, canEvaluate)
- Collections: plural form (points, values)
- Test methods: featureUnderTest_testScenario_expectedBehavior()

LAYOUT & FORMATTING
- Indentation: 4 spaces (no tabs)
- Line length: max 120 chars (soft limit 110)
- Wrapped lines: +8 spaces from parent
- Brackets: K&R style (opening brace same line)

METHOD FORMAT:
public void someMethod() throws SomeException {
    ...
}

CONTROL STRUCTURES:
if (condition) {
    statements;
} else {
    statements;
}

for (initialization; condition; update) {
    statements;
}

while (condition) {
    statements;
}

switch (condition) {
case ABC:
    statements;
    break;
default:
    statements;
    break;
}
Note: NO indentation for case clauses

try {
    statements;
} catch (Exception exception) {
    statements;
}

KEY RULES
- Every class must be in a package
- Import classes explicitly (no wildcards)
- Array specifiers on type: int[] a (not int a[])
- Always use curly brackets for loops/conditionals (even single statements)
- Conditionals on separate line
- All comments in English
- Use Google Java Style Guide for uncovered topics

JAVADOC FORMAT:
/**
 * Returns description of what method does.
 *
 * @param x Parameter description.
 * @return Return value description.
 * @throws Exception When this exception occurs.
 */