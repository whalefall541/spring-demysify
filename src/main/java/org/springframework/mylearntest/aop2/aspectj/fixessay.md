# 初始配置Git

```shell script
git config --global user.name "Your Name"
git config --global user.email "email@example.com"
```

# 本地分支回滚版本

查看版本

```shell script
git log
git reflog
```

回滚

```shell script
git reset --hard HEAD^
git reset --hard 55275
```

# 查看文件区别

`git diff test.txt`

# 撤销修改 
将文件恢复到最近一次add 或 commit之前的状态

`git checkout -- test.txt`

- 把暂存区的修改撤销掉
```shell script
git reset HEAD test.txt
git restore --staged test.txt
```

# 本地关联到远程仓库：

```shell script
git remote add origin git@github.com:whalefall541/test.git
# 远程仓库地址 远程分支名:本地分支名
git pull git@github.com:whalefall541/test.git master:master 
git push -u origin master
```

# 删除远程仓库关联 

`git remote rm origin `

# 创建并切换到本地分支 -- 理想情况主分支没变化

```shell script
git checkout -b dev     # 开发完成之后,
git checkout master     # 切换到master分支
git merge dev           # 移动master指针到dev位置
git branch -d dev       # 删除分支
```

CONFLICT (content): Merge conflict in test3.txt

手动修复文件 

- \>>>>> HEAD 
- aaaa
- =====
- bbbb
- <<< DEV 

关闭自动合并
`git merge --no-ff -m "merge with no-ff" dev`

# 临时在dev开发,突然要创建FixBug去修复master分支上的bug

保存add的内容

```shell script
git add test5.txt
git stash
```

创建修复分支
```shell script
git checkout -b fixbug
vim test4.txt
git add test4.txt
git commit -m " fix bug in test4.txt"
```

合并修复的内容到master,并且删除fixbug分支
```shell script
git checkout master
git merge fixbug
git branch -d fixbug
```

回到当前开发分支dev 
```shell script
git checkout dev
git stash list 
git stash pop # 恢复暂存在stash中的内容
vim test5.txt
git add test5.txt
git commit -m "add test5.txt"
```

切回master合并dev内容
```shell script
git checkout master
git merge dev
git branch -d dev
git push
```
 
# 在多人使用远程仓库进行工作时，往往在同一个分支上的操作会存在冲突，此时需要远程冲突合并。
* 多人协作的工作模式通常是这样：
* 首先，可以试图用git push origin <branch-name>推送自己的修改；
* 如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；
* 如果合并有冲突，则解决冲突，并在本地提交；
* 没有冲突或者解决掉冲突后，再用git push origin <branch-name>推送就能成功！
* 如果git pull提示no tracking information，则说明本地分支和远程分支的链接关系没有创建，用命令git branch --set-upstream-to <branch-name> origin
/<branch-name>

# 标签

在当前分支当前提交上打标签：
`git tag v1.0`

如果想要打标签在某个指定历史commit上：
`git tag v0.9 f52c633`

可以通过如下命令查看一个tag信息：
`git show v0.1`

如果标签打错了，也可以删除：
`git tag -d v0.1`

如果要推送某个标签到远程，使用命令git push origin <tagname>
```shell script
git push origin v1.0
# 或者，一次性推送全部尚未推送到远程的本地标签：
git push origin --tags	
# 如果标签已经推送到远程，要删除远程标签就麻烦一点，先从本地删除：
git tag -d v0.9	
# 然后，从远程删除。删除命令也是push，但是格式如下：
git push origin :refs/tags/v0.9
```


# .gitignore

.gitignore只能忽略那些原来没有被track的文件，如果某些文件已经被纳入了版本管理中，则修改.gitignore是无效的。

解决方法就是先把本地缓存删除（改变成未track状态），然后再提交:
```shell script
git rm -r --cached .
git add .
git commit -m 'update .gitignore'
git push
```


# alias
- 配置别名：
- $ git config --global alias.st status
- 删除别名
- 在[user_dir]/.gitconfig 文件中删除 [alias]下的内容