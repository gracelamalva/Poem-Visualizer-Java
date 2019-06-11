<h2>Developer's Guide</h2>

<h3>Summary</h3>

A good project built with a team always defines how it expects each member of that team to contribute. In order for code to remain clean, it is usually a nice idea to lay forth a set of expectations and suggestions for how code should be added and managed on a project. Every project is different, every developer is unique.

<h3>Command Reference</h3>

This is paraphrased from the [GitHub Education Cheat Sheet](https://education.github.com/git-cheat-sheet-education.pdf)!

<h4>Git Setup</h4>

Configure the name that shows up on commits

```git
git config --global user.name [name]
```

Configure the email (I recommend an email associated with your GitHub account) that shows up on commits

```git
git config --global user.email [email]
```

<h4>Repo Setup</h4>

Initialize a new local Git repository in the current directory, otherwise specify the target directory

```git
git init <target>
```

Clone an existing remote repository into the current directory otherwise specify the target directory

```git
git clone [url] <target>
```

<h4>Manage Changes</h4>

Show all files that have been modified in the working directory

```git
git status
```

Add a file in the working directory to the staged changes for the next commit

```git
git add [file]
```

Commit your staged changes as a new commit with the specified message

```git
git commit -m [message]
```

<h4>Sharing & Updating</h4>

Pushes all committed changes to the default remote repository and branch, unless otherwise specified

```git
git push <alias> <branch>
```

Pulls all changes from the remote repository (This is a concatenation of ```git fetch``` and ```git merge```)

```git
git pull
```

<h3>Commit Messages</h3>

The following commit tags can be used to preface commit messages and provide wonderful context

<table>
  <thead>
    <tr>
      <th>Tag Type</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>[MOD]</td>
      <td>Modified existing code</td>
    </tr>
    <tr>
      <td>[ADD]</td>
      <td>Added new code</td>
    </tr>
    <tr>
      <td>[FIX]</td>
      <td>Fixed a bug</td>
    </tr>
    <tr>
      <td>[STYLE]</td>
      <td>Changed code styling</td>
    </tr>
    <tr>
      <td>[DOC]</td>
      <td>Changed documentation</td>
    </tr>
    <tr>
      <td>[TEST]</td>
      <td>Changed test cases</td>
    </tr>
    <tr>
      <td>[CHORE]</td>
      <td>Changed settings and configurations</td>
    </tr>
  </tbody>
</table>

For example:

```git
[FIX] Stopped very bag evil bug #75666
```

```git
[DOC] Changed the commit tags in DEVELOPER.md
```

```git
[CHORE] Added .gitignore entries
```