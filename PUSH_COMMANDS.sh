#!/bin/bash

# ═══════════════════════════════════════════════════════════════════════════
# 🚀 PUSH TO GITHUB - RUN THESE COMMANDS WHEN GITHUB IS BACK ONLINE
# ═══════════════════════════════════════════════════════════════════════════

echo "════════════════════════════════════════════════════════════════════════"
echo "  📦 Pushing OpenCart Framework to GitHub"
echo "════════════════════════════════════════════════════════════════════════"
echo ""

# Step 1: Navigate to project directory
echo "📁 Step 1: Going to project directory..."
cd ~/eclipse-workspace/java-practice/Opencart100
echo "✅ Current directory: $(pwd)"
echo ""

# Step 2: Check git status
echo "🔍 Step 2: Checking git status..."
git status
echo ""

# Step 3: Login to GitHub (using vidhyasai92 account)
echo "🔐 Step 3: Logging into GitHub..."
echo "   A browser window will open. Please login with: vidhyasai92"
echo ""
gh auth login --web
echo ""

# Step 4: Create repository on GitHub
echo "🏗️  Step 4: Creating repository on GitHub..."
echo "   Repository name: opencart-automation-framework"
echo "   Account: vidhyasai92"
echo ""
gh repo create opencart-automation-framework \
  --public \
  --description "Selenium WebDriver automation framework for OpenCart e-commerce application with Page Object Model, TestNG, and ExtentReports" \
  --source=. \
  --remote=origin
echo ""

# Step 5: Rename branch to main
echo "🔄 Step 5: Renaming branch to main..."
git branch -M main
echo "✅ Branch renamed to main"
echo ""

# Step 6: Push to GitHub
echo "🚀 Step 6: Pushing code to GitHub..."
git push -u origin main
echo ""

# Step 7: Success!
echo "════════════════════════════════════════════════════════════════════════"
echo "  ✅ SUCCESS! Your project is now on GitHub!"
echo "════════════════════════════════════════════════════════════════════════"
echo ""
echo "🌐 View your repository at:"
echo "   https://github.com/vidhyasai92/opencart-automation-framework"
echo ""
echo "🎉 Congratulations! Your framework is now public!"
echo ""
