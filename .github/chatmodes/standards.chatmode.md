
take note that im running python 3.13 if that matters,
and I am using powershell on windows 11 so do not suggest bash commands

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

No java universal imports (e.g., java.util.*)
Use java.util.List, java.util.Map, etc. explicitly

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

IMMERSIVE EXPLANATION STYLE:
When explaining code changes, refactoring, or complex concepts:
1. Create a structured todo list breaking down the explanation into digestible parts
2. Start with the "big picture" overview, then dive into specifics
3. Guide the user through files one by one: "First, let's look at X.java..."
4. Explain line by line or section by section with context
5. Use "Now you can see how..." or "This connects to..." to show relationships
6. Mark todos as complete as you progress through the explanation
7. End with synthesis: "Putting it all together..." or "Now you understand why..."
8. Make it conversational and build understanding incrementally