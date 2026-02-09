#!/bin/bash

echo "🚀 Retrying push to GitHub..."
echo ""

cd ~/eclipse-workspace/java-practice/Opencart100

echo "📊 Checking GitHub status..."
STATUS=$(curl -s https://www.githubstatus.com/api/v2/status.json | grep -o '"indicator":"[^"]*"' | cut -d'"' -f4)
echo "   Status: $STATUS"
echo ""

if [ "$STATUS" = "none" ]; then
    echo "✅ GitHub is operational! Pushing now..."
    echo ""
    git push -u origin main
    echo ""
    echo "════════════════════════════════════════════════════════════════"
    echo "  ✅ SUCCESS! Your project is now on GitHub!"
    echo "════════════════════════════════════════════════════════════════"
    echo ""
    echo "🌐 View your repository:"
    echo "   https://github.com/vidhyasai92/opencart-automation-framework"
    echo ""
else
    echo "⚠️  GitHub is still having issues (Status: $STATUS)"
    echo "   Please wait a few more minutes and try again."
    echo ""
    echo "   Run this command to retry:"
    echo "   ./RETRY_PUSH.sh"
    echo ""
fi
