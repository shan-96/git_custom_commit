package com.github.shan-96.gitcustomcommit.services

import com.intellij.openapi.project.Project
import com.github.shan-96.gitcustomcommit.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
