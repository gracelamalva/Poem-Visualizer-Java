<h2>Poem Visualizer Java</h2>
<h4>Detects and highlights all rhymes from a given song or poem</h5>

<h3>Contributors</h3>

-Kiowe Smith https://github.com/kiowesmith21

<h3>Requirements</h3>

- I usually add what is needed to compile or run this project
- Sometimes the Java version
- Sometimes the Maven version
- Even Git version if relevant
- If you're feeling spicy, add a meme too

<h3>Version Control</h3>

This section is up to personal preference, I usually include some start points for people who may want to contribute. Delete, edit, or mess with this README.md to your hearts content. I was just a little bored on a Monday night.

For example: To contribute to this project, start by cloning the repository:

```git
git clone https://github.com/gracelamalva/Poem-Visualizer-Java.git
```

I tend to include a [developer guide](DEVELOPER.md) as well that details the coding conventions and styles for the project and or some helpful commands for proper use of Github.

Read the [developer guide](DEVELOPER.md)!

<h3>Uploading Existing Code Despite Me Already Pushing This Code First!!!</h3>

So I assume if you have code to push, now that I put this here it might a little weird to push it if you have an existing repo.

Navigate to the directory with the project files, open a Git command prompt.

If it is not yet a local Git repo, run the following command:

```git
git init
```

Once the project is a confirmed local Git repo, the following commands will add the remote repository, set the fetch and push url, pull the changes from remote repository to local repository and merge changes if necessary.

```git
git remote add origin https://github.com/gracelamalva/Poem-Visualizer-Java.git

git remove -v

git pull origin master
```

Once the remote repository files have been properly pulled into the local repository, proceed to add the desired files and then push them to the remote repository.

```git
git add --add-all

git push origin master
```

In the event that there was an existing local Git repository with existing commits, ignore this, nuke my changes, start fresh.
